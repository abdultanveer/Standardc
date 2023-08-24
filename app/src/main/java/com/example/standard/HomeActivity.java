package com.example.standard;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity implements View.OnFocusChangeListener {
    String[] countries = {"India","china","pakistan","bangladesh","srilanka"};

    public static String TAG = HomeActivity.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ListView cListView = findViewById(R.id.langListview);
        registerForContextMenu(cListView);

        Button selButton = findViewById(R.id.btnSelect);
        registerForContextMenu(selButton);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, //layout of each row of listview
                countries);
        cListView.setAdapter(adapter);

        Log.i(TAG,"oncreate");
        EditText contactEditText = findViewById(R.id.etContact);
        contactEditText.setOnFocusChangeListener(this);

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
        //put this data into an intent
        Intent retIntent = new Intent();
        retIntent.putExtra("con",contact);
        //set the result -- the main activity knows whether the data is good to be consumed or rejected
        setResult(RESULT_OK,retIntent);  //RESULT_OK -- smell
        //close this activity
        finish();
    }

    @Override
    public void onFocusChange(View view, boolean isFocussed) {
        if(isFocussed){
            Toast.makeText(this, "its foccused", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this, "lost focus", Toast.LENGTH_SHORT).show();

        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
         super.onCreateOptionsMenu(menu);
         getMenuInflater().inflate(R.menu.home_menu,menu); //inflation = parsing xml
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
         super.onOptionsItemSelected(item);
        switch (item.getItemId()){


        }
        return true;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.list_menu,menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
         super.onContextItemSelected(item);
         switch (item.getItemId()){

         }

        return true;
    }
}