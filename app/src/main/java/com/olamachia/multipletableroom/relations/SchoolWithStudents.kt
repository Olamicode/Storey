package com.olamachia.multipletableroom.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.olamachia.multipletableroom.entities.School
import com.olamachia.multipletableroom.entities.Student


/**
 * This joins the school and students table using the
 * schoolName as the @primarykey and the schoolName as
 * the common @property in a one to many relationship
 * */

data class SchoolWithStudents(
    @Embedded val school: School,
    @Relation(
        parentColumn = "schoolName",
        entityColumn = "schoolName"
    )
    val students: List<Student>
)
