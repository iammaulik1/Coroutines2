package com.example.coroutine

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val TAG:String ="KOTLINFUN"

    init {
        viewModelScope.launch {
            while (true){
                delay(500)
                Log.d(TAG,"Hello....")
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        Log.d(TAG,"ViewModel Destroyed")
    }
}

