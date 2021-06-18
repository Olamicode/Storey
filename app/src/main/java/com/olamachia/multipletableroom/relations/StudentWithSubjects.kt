package com.olamachia.multipletableroom.relations

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.olamachia.multipletableroom.entities.Student
import com.olamachia.multipletableroom.entities.Subject

data class StudentWithSubjects(
    @Embedded val student: Student,
    @Relation(
        parentColumn = "studentName",
        entityColumn = "subjectName",
        associateBy = Junction(StudentSubjectCrossRef::class)
    )
    val subjects: List<Subject>
)
