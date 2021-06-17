package com.olamachia.multipletableroom.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.olamachia.multipletableroom.entities.Director
import com.olamachia.multipletableroom.entities.School

data class SchoolAndDirector(
    @Embedded val school: School,
    @Relation(
        parentColumn = "schoolName",
        entityColumn = "schoolName"
    )
    val director: Director
)
