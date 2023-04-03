package com.example.coroutine

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.*

class MainActivity5 : AppCompatActivity() {

    private val TAG:String ="KOTLINFUN"

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
    }

    /////**********  withContext()

    private suspend fun executeTask(){
        Log.d(TAG,"Before")
        withContext(Dispatchers.IO) {
            delay(1000)
            Log.d(TAG,"Inside")
        }
        Log.d(TAG,"After")
    }

    //****************  runBlocking() : Until the coroutines are finished , it'll hold the thread

    //general use of runblock implementation

    /*
     fun main()= runBlocking{
                launch {
                    delay(1000)
                    println("World")
                }
                println("Hello")
            }
    }
    */

    fun main(){
        runBlocking {
            launch {
                delay(1000)
                println("World")
            }
            println("Hello")
        }
    }


}