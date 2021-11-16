package com.andrest.university.db

import android.app.Application
import androidx.room.Room

class StudentApp : Application() {

    val room = Room
            .databaseBuilder(this, StudentDb::class.java, "student")
            .build()
}