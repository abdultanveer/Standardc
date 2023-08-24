package com.example.standard

import android.database.Cursor
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.LayoutManager


class ContentproviderActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contentprovider)
        //uri to sms inbox
        val uriSms = Uri.parse("content://sms/inbox")
        //query the inbox
        val dataCursor: Cursor? = getContentResolver().query(uriSms, null, null, null, null)
        //put the queried data into an adapter
        var adapter = CpAdapter(dataCursor)
        //set the adapter onto a listview
        var cpRecyclerView:RecyclerView = findViewById(R.id.contentProviderList)
        var layoutManager = LinearLayoutManager(this)
        cpRecyclerView.layoutManager = layoutManager
        cpRecyclerView.adapter = adapter
    }
}