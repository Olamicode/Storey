package com.olamachia.multipletableroom.dao

import androidx.room.Database
import androidx.room.RoomDatabase
import com.olamachia.multipletableroom.entities.Director
import com.olamachia.multipletableroom.entities.School
import com.olamachia.multipletableroom.entities.Student
import com.olamachia.multipletableroom.entities.Subject
import com.olamachia.multipletableroom.relations.StudentSubjectCrossRef

@Database(
    entities = [Director::class, School::class, Student::class, Subject::class, StudentSubjectCrossRef::class],
    version = 1
)
abstract class SchoolDatabase: RoomDatabase() {
    abstract fun schoolDao(): SchoolDao
}