package com.andrest.university

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.andrest.university.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnDelete.setOnClickListener {
            binding.etName.setText("")
        }


    }
}