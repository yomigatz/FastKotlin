package com.yomigatz.fastkotlin

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide

/**
 * Author: umi
 * Date: 2021/12/19 3:14
 * Description: This is GlidTest.
 */
class GlideTest {

    fun into(context: Context, url: String, imageView: ImageView) {
        Glide.with(context)
            .load(url)
            .into(imageView)
    }

}