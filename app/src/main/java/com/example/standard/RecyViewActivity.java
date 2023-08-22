package com.example.standard;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class RecyViewActivity extends AppCompatActivity {
    String[] countries = {"India","china","pakistan","bangladesh","srilanka"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recy_view);
    }
}