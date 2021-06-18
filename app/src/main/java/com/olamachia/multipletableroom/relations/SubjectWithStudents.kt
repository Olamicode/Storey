package com.olamachia.multipletableroom.relations

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.olamachia.multipletableroom.entities.Student
import com.olamachia.multipletableroom.entities.Subject

data class SubjectWithStudents(
    @Embedded val subject: Subject,
    @Relation(
        parentColumn = "subjectName",
        entityColumn = "studentName",
        associateBy = Junction(StudentSubjectCrossRef::class)
    )
    val students: List<Student>
)
