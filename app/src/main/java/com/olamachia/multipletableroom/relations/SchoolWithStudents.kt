package com.olamachia.multipletableroom.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.olamachia.multipletableroom.entities.School
import com.olamachia.multipletableroom.entities.Student

data class SchoolWithStudents(
    @Embedded val school: School,
    @Relation(
        parentColumn = "schoolName",
        entityColumn = "schoolName"
    )
    val students: List<Student>
)
