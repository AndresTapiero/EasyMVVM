package com.andrest.university

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.andrest.university.databinding.ActivityMainBinding
import com.andrest.university.model.Students
import com.andrest.university.model.StudentsProvider
import com.andrest.university.viewmodel.StudentViewModel

class MainActivity : AppCompatActivity() {

    private val key = "MY_KEY"
    private val studentViewModel: StudentViewModel by viewModels()

    val arrayList: ArrayList<Students> = ArrayList<Students>()
    var list: MutableList<Students> = mutableListOf<Students>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        list.add(Students("Andres","Tapi",4.0))
        list.add(Students("Brandon","Robles",3.0))
        arrayList.addAll(list)



        studentViewModel.studentModel.observe(this, Observer {
           // binding.etName.text = it.name
           // binding.etLastName.text = it.lastName
        })

        binding.btnDelete.setOnClickListener {
            binding.etName.setText("")
            binding.etLastName.setText("")
            binding.etPromedio.setText("")
        }

        binding.btnSend.setOnClickListener {

            if ( !binding.etName.text.isNullOrEmpty() &&  !binding.etLastName.text.isNullOrEmpty() && !binding.etPromedio.text.isNullOrEmpty()) {
                val intent: Intent = Intent(this, StudentRegister::class.java)
                intent.putExtra("data", binding.etName.text.toString())
                startActivity(intent)


            } else {
                Toast.makeText(this,"Por favor ingrese los datos ", Toast.LENGTH_LONG).show();
            }

        }

        binding.btnAllStudents.setOnClickListener {
            val intent: Intent = Intent(this, AllStudents::class.java)
            startActivity(intent)
        }


    }
}