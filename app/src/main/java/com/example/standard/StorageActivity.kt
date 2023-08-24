package com.example.standard

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText

class StorageActivity : AppCompatActivity() {
    lateinit var etTitle:EditText
    lateinit var etSubtitle:EditText
    //EditText etTitle;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_storage)
        etTitle = findViewById(R.id.etTitle)
        etSubtitle = findViewById(R.id.etSubtitle)
    }

    override fun onPause() {
        super.onPause()
        storeData()
    }

    private fun storeData() {
        //get the data from the edittext
        var title = etTitle.text.toString()
        var subtitle = etSubtitle.text.toString()
        //create a file
        var sharedprefs = getSharedPreferences("sc_prefs_filename", MODE_PRIVATE)
        //open the file in edit mode
        var editor = sharedprefs.edit()
        //write to the file
        editor.putString("ktitle",title)
        editor.putString("ksubtitle",subtitle)
        //save the file
        editor.apply()
    }

    override fun onResume() {
        super.onResume()
        restoreData()
    }

    private fun restoreData() {
        //open the file
        var sharedprefs = getSharedPreferences("sc_prefs_filename", MODE_PRIVATE)
        //read the data
        var title = sharedprefs.getString("ktitle","")
        var sTitle = sharedprefs.getString("ksubtitle","")
        //put the data into edittexts
        etTitle.setText(title)
        etSubtitle.setText(sTitle)

    }
}