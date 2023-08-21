package com.example.standard;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

      String data =   getIntent()   //get intent which started this activity
                .getExtras()
                .getString("sc");
        TextView tvResult = findViewById(R.id.tvResult);
        tvResult.setText(data);

    }
}