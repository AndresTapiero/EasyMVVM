package com.andrest.university.repository

import androidx.lifecycle.LiveData
import com.andrest.university.dao.StudentDao
import com.andrest.university.model.Student

class StudentRepository(private val studentDao: StudentDao) {

    val readAllData: LiveData<List<Student>> = studentDao.getAllStudents()

    suspend fun addStudent(student: Student) {
        studentDao.addStudent(student)
    }

    fun deleteAllStudent() {
        studentDao.deleteAllStudents()
    }
}