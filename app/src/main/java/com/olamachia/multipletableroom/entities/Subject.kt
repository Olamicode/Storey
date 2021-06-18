package com.olamachia.multipletableroom.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "subject_table")
data class Subject(
    @PrimaryKey(autoGenerate = false)
    val subjectName: String
)
