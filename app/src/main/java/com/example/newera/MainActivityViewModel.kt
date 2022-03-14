package com.example.newera

import android.os.CountDownTimer
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.util.concurrent.TimeUnit

class MainActivityViewModel() : ViewModel() {
    private lateinit var countDownTimer: CountDownTimer
    private val _seconds = MutableLiveData<Int>()
    val seconds: LiveData<Int>
        get() = _seconds

    private val _isFinished = MutableLiveData<Boolean>()
    val finished: LiveData<Boolean>
        get() = _isFinished

    fun startTimer() {
        countDownTimer = object : CountDownTimer(10000, 1000) {
            override fun onFinish() {
                _isFinished.value = true
            }

            override fun onTick(millisUntilFinished: Long) {
                val timeRemainingInSeconds =
                    TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished)
                _seconds.value = timeRemainingInSeconds.toInt()
            }
        }.start()
    }

    fun stopTimer() {
        countDownTimer.cancel()
    }
}