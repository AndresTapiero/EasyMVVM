package com.andrest.university.views

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.andrest.university.databinding.ActivityStudentRegisterBinding
import com.andrest.university.util.Resources.Companion.AVERAGE_TEXT

class StudentRegister : AppCompatActivity() {

    companion object {
        const val NAME_STUDENT_KEY = "name"
        const val AVERAGE_STUDENT_KEY = "average"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityStudentRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bundle = intent.extras
        val name = bundle?.get(NAME_STUDENT_KEY)
        val average = bundle?.get(AVERAGE_STUDENT_KEY)

        binding.name.text = name.toString() + " " + AVERAGE_TEXT + " " + average.toString()

        binding.viewContainer.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

    }
}