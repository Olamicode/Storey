package com.olamachia.multipletableroom.dao

import androidx.room.*
import com.olamachia.multipletableroom.entities.Director
import com.olamachia.multipletableroom.entities.School
import com.olamachia.multipletableroom.entities.Student
import com.olamachia.multipletableroom.relations.SchoolAndDirector
import com.olamachia.multipletableroom.relations.SchoolWithStudents

@Dao
interface SchoolDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSchool(school: School)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDirector(director: Director)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertStudent(student: Student)

    @Transaction
    @Query("SELECT * FROM school_table WHERE schoolName = :schoolName")
    suspend fun getSchoolAndDirectorWithSchoolName(schoolName: String): List<SchoolAndDirector>

    @Transaction
    @Query("SELECT * FROM school_table WHERE schoolName = :schoolName")
    suspend fun getSchoolWithStudentsWithSchoolName(schoolName: String): List<SchoolWithStudents>
}