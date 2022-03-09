package com.example.newera

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.newera.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    private lateinit var viewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableViewBinding()
        attachViewModel()
        refreshUi()
        attachUiListeners()
    }

    private fun attachViewModel() {
        viewModel =  ViewModelProvider(this).get(MainActivityViewModel::class.java)
    }

    private fun enableViewBinding() {
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun refreshUi() {
        binding.textView.text = viewModel.number.toString()
    }

    private fun attachUiListeners() {
        binding.button.setOnClickListener {
            viewModel.addNumber()
            refreshUi()
        }
    }
}