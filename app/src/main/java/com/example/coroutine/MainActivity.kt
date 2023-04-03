package com.example.coroutine

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import com.example.coroutine.databinding.ActivityMainBinding
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {


    private val TAG: String = "KotlinFun"


    lateinit var binding: ActivityMainBinding
    lateinit var counterText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        counterText = binding.counter

        Log.d(TAG, "${Thread.currentThread().name}")

        binding.addButton.setOnClickListener {
            updateCounter()
        }
        binding.minusButton.setOnClickListener {
            minusCounter()
        }
    }


    fun updateCounter() {
        Log.d(TAG, "${Thread.currentThread().name}")
        counterText.text = "${counterText.text.toString().toInt() + 1}"
    }

    // Hii Myself Maulik
    fun minusCounter() {
        Log.d(TAG, "${Thread.currentThread().name}")
        counterText.text = "${counterText.text.toString().toInt() - 1}"
    }

    fun doAction(view: View) {

        CoroutineScope(Dispatchers.IO).launch {
            Log.d(TAG,"1- ${Thread.currentThread().name}")
        }
        GlobalScope.launch(Dispatchers.Main) {
            Log.d(TAG,"2 -${Thread.currentThread().name}")
        }
        MainScope().launch(Dispatchers.Default) {
            Log.d(TAG,"3  -${Thread.currentThread().name}")
        }

    }
}