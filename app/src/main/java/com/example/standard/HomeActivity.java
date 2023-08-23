package com.example.standard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {
    String[] countries = {"India","china","pakistan","bangladesh","srilanka"};

    public static String TAG = HomeActivity.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
       // ListView cListView = findViewById(R.id.langListview);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, //layout of each row of listview
                countries);
       // cListView.setAdapter(adapter);

        Log.i(TAG,"oncreate");

      /*String data =   getIntent()   //get intent which started this activity
                .getExtras()
                .getString("sc");
        TextView tvResult = findViewById(R.id.tvResult);
        tvResult.setText(data);*/

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.v(TAG,"onStart-get the data");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.v(TAG,"onResume --restore the app state");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.w(TAG,"onPause-- save app state");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e(TAG,"onStop -hibernate");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG,"onDestroy");
    }

    public void handleSelection(View view) {
        EditText conEditText = findViewById(R.id.etContact);
        String contact = conEditText.getText().toString();
        TextView resTextView = findViewById(R.id.tvResult);
        resTextView.setText(contact);
        //put this data into an intent
       /* Intent retIntent = new Intent();
        retIntent.putExtra("con",contact);
        //set the result -- the main activity knows whether the data is good to be consumed or rejected
        setResult(RESULT_OK,retIntent);  //RESULT_OK -- smell
        //close this activity
        finish();*/
    }

    public void startService(View view) {
        Intent serviceIntent = new Intent(this,MyService.class);
        serviceIntent.putExtra("url","https://downloadimageurl.com");
        startService(serviceIntent);
    }

    public void stopService(View view) {
        Intent serviceIntent = new Intent(this,MyService.class);
        stopService(serviceIntent);
    }
}