package com.andrest.university.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.andrest.university.R
import com.andrest.university.model.Student
import com.andrest.university.util.Resources.Companion.AVERAGE_TEXT

class StudentsAdapter(private val students: List<Student>) :
    RecyclerView.Adapter<StudentsAdapter.ViewHolder>() {

    //Inflate view
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.user_result_item, parent, false)
        return ViewHolder(view)
    }

    //Assign view
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val student = students[position]
        holder.bind(student)
    }

    override fun getItemCount(): Int = students.size

    class ViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        private val name = view.findViewById<TextView>(R.id.tvName)
        private val average = view.findViewById<TextView>(R.id.tvAverage)

        fun bind(student: Student) {
            name.text = student.name + " " + student.lastName
            average.text = AVERAGE_TEXT + student.average
        }
    }
}