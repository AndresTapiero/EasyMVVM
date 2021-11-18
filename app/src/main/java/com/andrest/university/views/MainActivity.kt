package com.andrest.university.views

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.andrest.university.R
import com.andrest.university.databinding.ActivityMainBinding
import com.andrest.university.model.Student
import com.andrest.university.util.Resources.Companion.EMPTY
import com.andrest.university.util.Resources.Companion.PLEASE_DATA
import com.andrest.university.viewmodel.StudentViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var mStudentViewModel: StudentViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        mStudentViewModel = ViewModelProvider(this).get(StudentViewModel::class.java)
        listeners()
    }

    private fun listeners() {
        binding.btnDelete.setOnClickListener { clearEditTexts() }

        binding.btnSend.setOnClickListener { insertDataToDatabase() }

        binding.btnAllStudents.setOnClickListener {
            val intent: Intent = Intent(this, AllStudents::class.java)
            startActivity(intent)
        }
    }

    private fun insertDataToDatabase() {
        val sName = binding.etName.text.toString()
        val sLastName = binding.etLastName.text.toString()
        val sAverage = binding.etAverage.text.toString()

        if (sName.isNotEmpty() && sLastName.isNotEmpty() && sAverage.isNotEmpty()) {
            val student = Student(0, sName, sLastName, sAverage)
            // add data to database
            mStudentViewModel.addStudent(student)
            val intent = Intent(this, StudentRegister::class.java)

            intent.putExtra(StudentRegister.NAME_STUDENT_KEY, binding.etName.text.toString())
            intent.putExtra(StudentRegister.AVERAGE_STUDENT_KEY, binding.etAverage.text.toString())
            startActivity(intent)
            clearEditTexts()
        } else {
            Toast.makeText(this, PLEASE_DATA, Toast.LENGTH_LONG).show()
        }
    }

    private fun clearEditTexts() {
        binding.etName.setText(EMPTY)
        binding.etLastName.setText(EMPTY)
        binding.etAverage.setText(EMPTY)
    }

}