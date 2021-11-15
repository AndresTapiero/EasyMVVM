package com.andrest.university.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.andrest.university.databinding.ActivityStudentRegisterBinding
import com.andrest.university.util.Resources.Companion.AVERAGE_TEXT

class StudentRegister : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityStudentRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bundle = intent.extras
        val dato = bundle?.get("data")

        binding.name.text = dato.toString() + AVERAGE_TEXT

    }
}