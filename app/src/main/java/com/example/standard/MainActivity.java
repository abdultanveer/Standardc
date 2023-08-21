package com.example.standard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.AlarmClock;
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

    public void launchHome(View view) {
        /*switch (view.getId()){
            case R.id.btnHome:*/
                Intent homeIntent = new Intent(this,HomeActivity.class); //explicit intent
                startActivity(homeIntent);
              /*  break;
            case R.id.btnDial:

                break;
        }*/

    }

    public void launchDialer(View view) {
        /*Intent dialIntent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:+91-9880979732")); //implicit intent
        startActivity(dialIntent);*/

        createAlarm("std-ch alarm",13,39);
    }

    public void createAlarm(String message, int hour, int minutes) {
        Intent intent = new Intent(AlarmClock.ACTION_SET_ALARM)
                .putExtra(AlarmClock.EXTRA_MESSAGE, message)
                .putExtra(AlarmClock.EXTRA_HOUR, hour)
                .putExtra(AlarmClock.EXTRA_MINUTES, minutes);
       // if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
       // }
    }
}