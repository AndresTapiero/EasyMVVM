package com.andrest.university.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.andrest.university.dao.StudentDao
import com.andrest.university.model.Student

@Database(
    entities = [Student::class],
    version = 1
)

abstract class StudentDb : RoomDatabase(){
    abstract fun studentDao(): StudentDao
}

