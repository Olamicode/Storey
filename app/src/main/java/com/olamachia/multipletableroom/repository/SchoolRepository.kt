package com.olamachia.multipletableroom.repository

import com.olamachia.multipletableroom.dao.SchoolDatabase
import com.olamachia.multipletableroom.entities.Director
import com.olamachia.multipletableroom.entities.School
import com.olamachia.multipletableroom.entities.Student
import com.olamachia.multipletableroom.entities.Subject
import com.olamachia.multipletableroom.relations.*
import javax.inject.Inject

class SchoolRepository @Inject constructor(
    private val schoolDatabase: SchoolDatabase
) {

    private val schoolDao = schoolDatabase.schoolDao()

    suspend fun insertSchool(school: School) {
        schoolDao.insertSchool(school)
    }

    suspend fun insertDirector(director: Director) {
        schoolDao.insertDirector(director)
    }

    suspend fun insertStudent(student: Student) {
        schoolDao.insertStudent(student)
    }

    suspend fun insertSubject(subject: Subject) {
        schoolDao.insertSubject(subject)
    }

    suspend fun insertStudentSubjectCrossRef(studentSubjectCrossRef: StudentSubjectCrossRef) {
        schoolDao.insertStudentSubjectCrossRef(studentSubjectCrossRef)
    }

    suspend fun getSchoolAndDirectorWithSchoolName(schoolName: String): List<SchoolAndDirector> {
        return schoolDao.getSchoolAndDirectorWithSchoolName(schoolName)
    }

    suspend fun getSchoolWithStudentsWithSchoolName(schoolName: String): List<SchoolWithStudents> {
        return schoolDao.getSchoolWithStudentsWithSchoolName(schoolName)
    }

    suspend fun getSubjectsOfStudent(studentName: String): List<StudentWithSubjects> {
        return schoolDao.getSubjectsOfStudent(studentName)
    }

    suspend fun getStudentsOfSubject(subjectName: String): List<SubjectWithStudents> {
        return schoolDao.getStudentsOfSubject(subjectName)
    }
}