package com.example.standard

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log

//make the code concise
class MyService : Service() {
    //class MyService extends Service{

    var TAG: String = MyService::class.java.simpleName

  /*  @Override
    protected void onCreate() {*/


    override fun onCreate() {
        super.onCreate()
        Log.i(TAG,"service created")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
         super.onStartCommand(intent, flags, startId)

        var url = intent?.extras?.getString("url")
        Log.i(TAG,"service started --"+url)

        return START_STICKY
    }


    override fun onDestroy() {
        super.onDestroy()
        Log.i(TAG,"service destroyed")

    }

    override fun onBind(intent: Intent): IBinder {
        TODO("Return the communication channel to the service.")
    }
}