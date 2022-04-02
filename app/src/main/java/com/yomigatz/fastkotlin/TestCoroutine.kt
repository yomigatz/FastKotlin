package com.yomigatz.fastkotlin

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/**
 * Author: umi
 * Date: 2022/4/1 11:51
 * Description: This is TestCoroutine.
 */
class TestCoroutine {

    private var callback: TestCallback? = null

    fun setCallback(callback: TestCallback) {
        this.callback = callback
    }

    fun loading() {
        GlobalScope.launch(Dispatchers.IO) {
            delay(2000)
            callback?.onSuccess("onSuccess")
            delay(1000)
            callback?.onSuccess2("onSuccess2")
            delay(1000)
            callback?.onFailed()
        }
    }

    interface TestCallback {
        fun onSuccess(succeed: String)
        fun onSuccess2(succeed: String)
        fun onFailed()
    }
}