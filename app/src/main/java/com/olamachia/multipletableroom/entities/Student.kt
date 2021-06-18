package com.olamachia.multipletableroom.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "students_table")
data class Student(
    @PrimaryKey(autoGenerate = false)
    val studentName: String,
    val semester: Int,
    val schoolName: String
)
