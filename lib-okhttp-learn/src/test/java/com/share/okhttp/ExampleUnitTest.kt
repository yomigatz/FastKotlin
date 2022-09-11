package com.share.okhttp

import org.junit.Test

import org.junit.Assert.*
import java.util.concurrent.ArrayBlockingQueue
import java.util.concurrent.ThreadPoolExecutor
import java.util.concurrent.TimeUnit

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun test() {
        val blockingQueue = ArrayBlockingQueue<Runnable>(1)
        val poolExecutor = ThreadPoolExecutor(
            0, Int.MAX_VALUE, 60, TimeUnit.SECONDS, blockingQueue
        )
        poolExecutor.execute {
            System.out.println("任务 task 1 :" + Thread.currentThread())
            while (true){

            }
        }

        poolExecutor.execute {
            System.out.println("任务 task 2 :" + Thread.currentThread())
        }
    }
}