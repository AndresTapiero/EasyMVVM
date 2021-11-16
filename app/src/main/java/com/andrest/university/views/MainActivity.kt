package com.andrest.university.views

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.andrest.university.R
import com.andrest.university.databinding.ActivityMainBinding
import com.andrest.university.db.StudentApp
import com.andrest.university.model.Student
import com.andrest.university.util.Resources.Companion.EMPTY
import com.andrest.university.util.Resources.Companion.PLEASE_DATA
import com.andrest.university.viewmodel.StudentViewModel

class MainActivity : AppCompatActivity() {

    private val studentViewModel: StudentViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding

    val arrayList: ArrayList<Student> = ArrayList<Student>()
    var list: MutableList<Student> = mutableListOf<Student>()

    val app = applicationContext as StudentApp

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        studentViewModel.studentModel.observe(this, Observer {
           // binding.etName.text = it.name
           // binding.etLastName.text = it.lastName
        })
        listeners()

        val allStudents = app.room.studentDao().getAllStudents()
    }

    private fun listeners(){
        binding.btnDelete.setOnClickListener {
            binding.etName.setText(EMPTY)
            binding.etLastName.setText(EMPTY)
            binding.etPromedio.setText(EMPTY)
        }

        binding.btnSend.setOnClickListener {

            if (!binding.etName.text.isNullOrEmpty() &&  !binding.etLastName.text.isNullOrEmpty() && !binding.etPromedio.text.isNullOrEmpty()) {
                val intent: Intent = Intent(this, StudentRegister::class.java)
                intent.putExtra("data", binding.etName.text.toString())
                startActivity(intent)

                list.add(Student(1, binding.etName.text.toString(), binding.etLastName.text.toString(), binding.etPromedio.toString()))
                println("list - " + list)

                //SQLITE
            } else {
                Toast.makeText(this, PLEASE_DATA, Toast.LENGTH_LONG).show();
            }

        }

        binding.btnAllStudents.setOnClickListener {
            val intent: Intent = Intent(this, AllStudents::class.java)
            startActivity(intent)
        }

    }
}