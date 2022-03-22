package com.yomigatz.fastkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.ListView

class MainActivity : AppCompatActivity() {

    var listView: ListView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var handler = Handler()
        setContentView(R.layout.activity_main)

    }
}