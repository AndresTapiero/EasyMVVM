package com.andrest.university.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.andrest.university.model.Student

@Dao
interface StudentDao {

    @Query("SELECT * FROM Student ORDER BY id ASC")
    fun getAllStudents(): LiveData<List<Student>>

    @Query("SELECT * FROM Student WHERE id = :id")
    fun getById(id: Int): Student

    @Update
    fun updateStudent(student: Student)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addStudent(students: Student)

    @Query("DELETE FROM Student")
    fun deleteAllStudents()
}