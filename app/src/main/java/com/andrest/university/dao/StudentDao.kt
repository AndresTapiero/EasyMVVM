package com.andrest.university.dao

import android.app.Person
import androidx.lifecycle.LiveData
import androidx.room.*
import com.andrest.university.model.Student

@Dao
interface StudentDao {

    @Query("SELECT * FROM Student")
    fun getAllStudents(): LiveData<List<Student>>

    @Query("SELECT * FROM Student WHERE id = :id")
    fun getById(id: Int):Person

    @Update
    fun updateStudent(student: Student)

    @Insert
    fun insert(students: List<Student>)

    @Delete
    fun delete(student: Student)
}