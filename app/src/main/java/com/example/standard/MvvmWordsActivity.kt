package com.example.standard

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import com.example.standard.data.Word
import com.example.standard.data.WordViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MvvmWordsActivity : AppCompatActivity() {

    private val wordViewModel: WordViewModel by viewModels {
        WordViewModel.WordViewModelFactory((application as WordsApplication).repository)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mvvm_words)

        val fab = findViewById<FloatingActionButton>(R.id.fab)
        fab.setOnClickListener {
            val intent = Intent(this@MvvmWordsActivity, NewWordActivity::class.java)
            startActivityForResult(intent, 123)
            //pleaseShowToast("fab was clicked")
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, intentData: Intent?) {
        super.onActivityResult(requestCode, resultCode, intentData)
        if (requestCode == 123 && resultCode == Activity.RESULT_OK) {
            intentData?.getStringExtra(NewWordActivity.EXTRA_REPLY)?.let { reply ->
                val word = Word(reply)
                wordViewModel.insert(word)
            }
        } else {
            pleaseShowToast("this is my message")
            Toast.makeText(
                applicationContext,
               "empty_not_saved",
                Toast.LENGTH_LONG
            ).show()
        }
    }

    fun Context.pleaseShowToast(message: String){
        Toast.makeText(applicationContext,message,Toast.LENGTH_SHORT).show()
    }
}