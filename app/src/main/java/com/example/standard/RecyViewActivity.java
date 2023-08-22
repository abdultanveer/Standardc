package com.example.standard;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.IntentFilter;
import android.os.Bundle;

public class RecyViewActivity extends AppCompatActivity {
    String[] countries = {"India","china","pakistan","bangladesh","srilanka"};
    SmsReceiver smsReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recy_view);
        CountriesAdapter adapter = new CountriesAdapter(countries);

        RecyclerView cRecyclerView = findViewById(R.id.recyclerListView);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        cRecyclerView.setLayoutManager(layoutManager);
        cRecyclerView.setAdapter(adapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        //dynamic receiver
        add(10,200);

    }

    private void add(int x, int y) {


        int j = 10;

        for(int i=1; i<5;i++){
            j = j*i;
        }
        throw  new NullPointerException("some reason");

    }


    @Override
    protected void onStop() {
        super.onStop();

    }
}