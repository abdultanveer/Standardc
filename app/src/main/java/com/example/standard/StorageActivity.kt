package com.example.standard

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class StorageActivity : AppCompatActivity() {
    var TAG = StorageActivity::class.java.simpleName
    lateinit var etTitle: EditText
    lateinit var etSubtitle: EditText

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
        editor.putString("ktitle", title)
        editor.putString("ksubtitle", subtitle)
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
        var title = sharedprefs.getString("ktitle", "")
        var sTitle = sharedprefs.getString("ksubtitle", "")
        //put the data into edittexts
        etTitle.setText(title)
        etSubtitle.setText(sTitle)

    }

    fun putFirestore(view: View) {
        var db = Firebase.firestore
        val user = hashMapOf(
            "first" to "Ada",
            "last" to "Lovelace",
            "born" to 1815
        )

        db.collection("users")
            .add(user)
            .addOnSuccessListener { documentReference ->
                Log.d(TAG, "DocumentSnapshot added with ID: ${documentReference.id}")
            }

    }

    fun getFirestore(view: View) {
        var db = Firebase.firestore


        db.collection("users")
            .get()
            .addOnSuccessListener { result ->
                for (document in result) {
                    Log.d(TAG, "${document.id} => ${document.data}")
                }
            }
            .addOnFailureListener { exception ->
                Log.w(TAG, "Error getting documents.", exception)
            }
    }
}