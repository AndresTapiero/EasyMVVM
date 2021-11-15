package com.andrest.university.views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.andrest.university.R
import com.andrest.university.databinding.ActivityMainBinding
import com.andrest.university.model.Students
import com.andrest.university.util.Resources.Companion.EMPTY
import com.andrest.university.util.Resources.Companion.PLEASE_DATA
import com.andrest.university.viewmodel.StudentViewModel

class MainActivity : AppCompatActivity() {

    private val key = "MY_KEY"
    private val studentViewModel: StudentViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding

    val arrayList: ArrayList<Students> = ArrayList<Students>()
    var list: MutableList<Students> = mutableListOf<Students>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        studentViewModel.studentModel.observe(this, Observer {
           // binding.etName.text = it.name
           // binding.etLastName.text = it.lastName
        })
        listeners()
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

                list.add(Students(binding.etName.text.toString(), binding.etLastName.text.toString(), binding.etPromedio.toString()))
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