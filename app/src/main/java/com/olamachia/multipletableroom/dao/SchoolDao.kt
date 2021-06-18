package com.olamachia.multipletableroom.dao

import androidx.room.*
import com.olamachia.multipletableroom.entities.Director
import com.olamachia.multipletableroom.entities.School
import com.olamachia.multipletableroom.entities.Student
import com.olamachia.multipletableroom.entities.Subject
import com.olamachia.multipletableroom.relations.*

@Dao
interface SchoolDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSchool(school: School)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDirector(director: Director)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertStudent(student: Student)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSubject(subject: Subject)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertStudentSubjectCrossRef(studentSubjectCrossRef: StudentSubjectCrossRef)

    @Transaction
    @Query("SELECT * FROM school_table WHERE schoolName = :schoolName")
    suspend fun getSchoolAndDirectorWithSchoolName(schoolName: String): List<SchoolAndDirector>

    @Transaction
    @Query("SELECT * FROM school_table WHERE schoolName = :schoolName")
    suspend fun getSchoolWithStudentsWithSchoolName(schoolName: String): List<SchoolWithStudents>

    @Transaction
    @Query("SELECT * FROM students_table WHERE studentName = :studentName")
    suspend fun getSubjectsOfStudent(studentName: String): List<StudentWithSubjects>

    @Transaction
    @Query("SELECT * FROM subject_table WHERE subjectName = :subjectName")
    suspend fun getStudentsOfSubject(subjectName: String): List<SubjectWithStudents>
}