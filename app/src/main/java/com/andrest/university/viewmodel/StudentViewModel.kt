package com.andrest.university.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.andrest.university.model.Students
import com.andrest.university.model.StudentsProvider

class StudentViewModel : ViewModel() {
    private val _studentModel = MutableLiveData<Students>()
    val studentModel: LiveData<Students> get() = _studentModel

    fun showStudents(){
        val student = StudentsProvider.students

        //studentModel.postValue(student)
    }

}

//LiveData: Permite subscriubis