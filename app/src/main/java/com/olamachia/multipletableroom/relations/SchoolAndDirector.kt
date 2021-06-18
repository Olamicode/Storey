package com.olamachia.multipletableroom.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.olamachia.multipletableroom.entities.Director
import com.olamachia.multipletableroom.entities.School

/**
 * This joins the school and director tables using the
 * schoolName as the @primarykey and the schoolName as
 * the common @property in a one to one relationship
 */

data class SchoolAndDirector(
    @Embedded val school: School,
    @Relation(
        parentColumn = "schoolName",
        entityColumn = "schoolName"
    )
    val director: Director
)
