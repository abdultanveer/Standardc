package com.example.standard;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText etName;
    TextView tvMain;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); //inflation -- layout inflater
       // inflateLayout();
         tvMain = findViewById(R.id.tvmain);
        etName = findViewById(R.id.etName); //getting handle on the view
    }

    private void inflateLayout() {
        ConstraintLayout constraintLayout = new ConstraintLayout(this);

       /* textView.setText("hello world");

        constraintLayout.addView(textView);*/
    }

    public void handleClick(View view) {
        //get the value from edittext
        String name = etName.getText().toString();
        //take the handle of the textview and
        TextView textView = findViewById(R.id.tvmain);
        //change the content of the textview
        textView.setText(name);
    }

    public void launchHome(View view) {
        /*switch (view.getId()){
            case R.id.btnHome:*/

                Intent homeIntent = new Intent(this,HomeActivity.class); //explicit intent
                homeIntent.putExtra("sc","android app dev at sc");
                startActivityForResult(homeIntent,123);
              /*  break;
            case R.id.btnDial:

                break;
        }*/

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent retIntent) {
        super.onActivityResult(requestCode, resultCode, retIntent);
        if(resultCode == RESULT_OK && requestCode ==123){ //if the result was not cancelled [stale food]
            String contact = retIntent.getExtras().getString("con");
            tvMain.setText(contact);
        }
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