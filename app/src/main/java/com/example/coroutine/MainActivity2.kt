package com.example.coroutine

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.yield

class MainActivity2 : AppCompatActivity() {

    private val TAG:String ="KOTLINFUN"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        CoroutineScope(Dispatchers.Main).launch {
            tasl1()
        }
        CoroutineScope(Dispatchers.Main).launch {
            tasl2()
        }
    }

    suspend fun tasl1() {
        Log.d(TAG,"STARTING TASK 1")
        yield()
        Log.d(TAG,"ENDING TASK 1")
    }

    suspend fun tasl2() {
        Log.d(TAG,"STARTING TASK 2")
        yield()
        Log.d(TAG,"ENDING TASK 2")
    }
}