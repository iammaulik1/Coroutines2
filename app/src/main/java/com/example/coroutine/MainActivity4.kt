package com.example.coroutine

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.*

class MainActivity4 : AppCompatActivity() {

    private val TAG: String = "KOTLINFUN"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    private suspend fun execute() {
        val parentJob = GlobalScope.launch(Dispatchers.Main) {

            Log.d(TAG, "Parent Started")

            var childjob = launch(Dispatchers.IO) {
                Log.d(TAG, "Child Job Started")
                delay(5000)
                Log.d(TAG, "Child Job Ended")
            }
            delay(3000)
            Log.d(TAG, "Child Job Cancelled")
            childjob.cancel() //cancellation of childjob
            Log.d(TAG, "Parent Ended")

        }
        parentJob.join()
        Log.d(TAG, "Parent Completed")
    }
}

