package com.example.standard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class RoomActivity extends AppCompatActivity {
    EditText etname, etemail, etpincode, etcity, etphoneNumber;
    Button button;
    int mPersonId;
    Intent intent;
   private AppDatabase mDb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room);
        mDb = AppDatabase.getInstance(this);
        initViews();
    }


    private void initViews() {
        etname = findViewById(R.id.edit_name);
        etemail = findViewById(R.id.edit_email);
        etpincode = findViewById(R.id.edit_pincode);
        etcity = findViewById(R.id.edit_city);
        etphoneNumber = findViewById(R.id.edit_number);
        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onSaveButtonClicked();
            }
        });
    }

    private void onSaveButtonClicked() {
        Person abdul = new Person(etname.getText().toString(), etemail.getText().toString(),
                etphoneNumber.getText().toString(), etpincode.getText().toString(), etcity.getText().toString());
                //"name","email","34567890","765432","bangalore");
         AppExecutors.getInstance().diskIO().execute(
                 new Runnable() {
                     @Override
                     public void run() {
                         mDb.personDao().insertPerson(abdul);
                     }
                 }
         );
    }

    public void findPerson(View view) {
        TextView tvPerson = findViewById(R.id.tvPersonDetails);
        EditText etPerson = findViewById(R.id.etPersonId);
        int id = Integer.parseInt(etPerson.getText().toString());
        AppExecutors.getInstance().diskIO().execute(
                new Runnable() {
                    @Override
                    public void run() {
                     Person found =   mDb.personDao().loadPersonById(id);
                     tvPerson.setText(found.name);
                    }
                }
        );
    }
}