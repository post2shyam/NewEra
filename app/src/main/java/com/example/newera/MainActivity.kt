package com.example.newera

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.newera.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    private lateinit var viewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableViewBinding()
        attachViewModel()
        attachListeners()
    }

    private fun attachViewModel() {
        viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
    }

    private fun enableViewBinding() {
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun attachListeners() {
        //Update on every tick
        viewModel.seconds.observe(this, Observer {
            binding.textView.text = it.toString()
        })

        //Update on timer finished
        viewModel.finished.observe(this, Observer {
            Toast.makeText(this, "Countdown finished", Toast.LENGTH_SHORT).show()
        })

        binding.start.setOnClickListener {
            viewModel.startTimer()
        }

        binding.stop.setOnClickListener {
            viewModel.stopTimer()
        }
    }
}