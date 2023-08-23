package com.example.standard

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.IBinder
import android.util.Log

class CalcService : Service() {
    var TAG = CalcService::class.java.simpleName
    private val binder = LocalBinder()

    fun add(a: Int, b:Int): Int {
        return a+b;
    }

    fun mul(a: Int, b:Int) =    a*b;
    fun div(a: Int, b:Int) =    a/b;

    inner class LocalBinder : Binder(){
        fun getService():CalcService =  this@CalcService

    }
    override fun onBind(p0: Intent?): IBinder? {
        return binder
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(TAG,"service destroyed")
    }
}