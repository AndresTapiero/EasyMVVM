package com.andrest.university.views

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.andrest.university.R
import com.andrest.university.adapters.StudentsAdapter
import com.andrest.university.model.Student

class AllStudents : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_all_students)

        val recycler = findViewById<RecyclerView>(R.id.rvStudents)

        recycler.adapter = StudentsAdapter(listOf(
            Student("Andres","Tapi","5.0"),
            Student("Brandon","Roble","5.0")
        ))

    }
}