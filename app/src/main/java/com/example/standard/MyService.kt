package com.example.standard

import android.app.Service
import android.content.Intent
import android.os.IBinder
//make the code concise
class MyService : Service() {
    //class MyService extends Service{

    override fun onBind(intent: Intent): IBinder {
        TODO("Return the communication channel to the service.")
    }
}