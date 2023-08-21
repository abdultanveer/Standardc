package com.example.standard;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText etName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etName = findViewById(R.id.etName);
    }

    public void handleClick(View view) {
        //get the value from edittext
        String name = etName.getText().toString();
        //take the handle of the textview and
        TextView textView = findViewById(R.id.textView);
        //change the content of the textview
        textView.setText(name);
    }
}