package com.yomigatz.fastkotlin

import okhttp3.OkHttpClient
import okhttp3.Request

/**
 * Author: umi
 * Date: 2021/12/19 0:20
 * Description: This is OkHttpTest.
 */
class OkHttpTest {
    var mOkHttpClient: OkHttpClient? = null
    var mUrl: String = ""

    fun init() {
        val request = Request.Builder()
            .url(mUrl)
            .build()
        val respose = mOkHttpClient?.newCall(request)?.execute()
    }

    fun okhttpAsyGet() {

        11111111

        22222222
    }


}