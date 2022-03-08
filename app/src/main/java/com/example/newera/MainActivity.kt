package com.example.newera

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.newera.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        intUi()
    }

    private fun intUi() {
        binding.button.setOnClickListener {
            Toast.makeText(this, "Button Pressed", Toast.LENGTH_SHORT).show()
        }
    }
}