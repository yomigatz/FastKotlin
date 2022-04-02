package com.yomigatz.fastkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.View
import android.widget.ListView
import kotlinx.coroutines.*
import kotlin.coroutines.resume

class MainActivity : AppCompatActivity() {

    var listView: ListView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var handler = Handler()
        setContentView(R.layout.activity_main)

    }

    fun onCancelCoroutine(view: View) {
        GlobalScope.launch(Dispatchers.IO) {
            val test = getData()
            Log.d("NRRR","onCancelCoroutine+++++$test")
        }
    }

    suspend fun getData():String? = suspendCancellableCoroutine{
        cancellableCoroutine->
        val test = TestCoroutine()
        test.setCallback(object :TestCoroutine.TestCallback{
            override fun onSuccess(succeed: String) {
                Log.d("NRRR","onSuccess+++++")
                cancellableCoroutine.resumeIfActive(succeed)
            }
            override fun onSuccess2(succeed: String) {
                Log.d("NRRR","onSuccess2+++++")
                cancellableCoroutine.resumeIfActive(succeed)
            }
            override fun onFailed() {
                Log.d("NRRR","onFailed+++++")
                cancellableCoroutine.resumeIfActive("++++++")
            }
        })
        test.loading()
    }

    private fun <T> CancellableContinuation<T>.resumeIfActive(value: T) {
        if (isActive) {
            resume(value)
        }
    }
}

