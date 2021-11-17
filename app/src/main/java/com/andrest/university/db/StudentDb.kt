package com.andrest.university.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.andrest.university.dao.StudentDao
import com.andrest.university.model.Student

@Database(
    entities = [Student::class],
    version = 1,
    exportSchema = false
)

abstract class StudentDb : RoomDatabase() {
    abstract fun studentDao(): StudentDao

    companion object {
        @Volatile
        private var INSTANCE: StudentDb? = null

        fun getDatabase(context: Context): StudentDb {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    StudentDb::class.java,
                    "student"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}

