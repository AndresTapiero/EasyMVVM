package com.andrest.university

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.andrest.university.databinding.ActivityStudentRegisterBinding

class StudentRegister : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityStudentRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bundle = intent.extras
        val dato = bundle?.get("data")

        binding.name.text = dato.toString() + " tu promedio es"

    }
}