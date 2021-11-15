package com.andrest.university.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.andrest.university.R
import com.andrest.university.adapters.StudentsAdapter
import com.andrest.university.model.Students

class AllStudents : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_all_students)

        val recycler = findViewById<RecyclerView>(R.id.rvStudents)

        recycler.adapter = StudentsAdapter(listOf(
            Students("Andres","Tapi","5.0"),
            Students("Brandon","Roble","5.0")
        ))

    }
}