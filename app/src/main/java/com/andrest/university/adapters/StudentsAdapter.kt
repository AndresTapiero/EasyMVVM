package com.andrest.university.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.andrest.university.R
import com.andrest.university.model.Student
import com.andrest.university.util.Resources.Companion.AVERAGE_TEXT

class StudentsAdapter :
    RecyclerView.Adapter<StudentsAdapter.ViewHolder>() {

    private var studentList = emptyList<Student>()

    //Inflate view
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.user_result_item, parent, false)
        return ViewHolder(view)
    }

    //Assign view
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentStudent = studentList[position]
        holder.bind(currentStudent)
    }

    override fun getItemCount(): Int = studentList.size

    class ViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        private val id = view.findViewById<TextView>(R.id.tvId)
        private val name = view.findViewById<TextView>(R.id.tvName)
        private val average = view.findViewById<TextView>(R.id.tvAverage)

        fun bind(student: Student) {
            id.text = student.id.toString()
            name.text = student.name + " " + student.lastName
            average.text = AVERAGE_TEXT + " " + student.average
        }
    }

    fun setData(student: List<Student>) {
        this.studentList = student
        notifyDataSetChanged()
    }
}