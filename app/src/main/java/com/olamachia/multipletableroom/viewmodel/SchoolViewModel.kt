package com.olamachia.multipletableroom.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.olamachia.multipletableroom.entities.Director
import com.olamachia.multipletableroom.entities.School
import com.olamachia.multipletableroom.entities.Student
import com.olamachia.multipletableroom.entities.Subject
import com.olamachia.multipletableroom.relations.*
import com.olamachia.multipletableroom.repository.SchoolRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SchoolViewModel @Inject constructor(private val schoolRepository: SchoolRepository) :
    ViewModel() {

    private val _schoolAndDirectorResponse = MutableLiveData<List<SchoolAndDirector>>()
    val schoolAndDirectorResponse: LiveData<List<SchoolAndDirector>> get() = _schoolAndDirectorResponse

    private val _schoolWithStudentResponse = MutableLiveData<List<SchoolWithStudents>>()
    val schoolWithStudentResponse: LiveData<List<SchoolWithStudents>> get() = _schoolWithStudentResponse

    private val _studentWithSubjectsResponse = MutableLiveData<List<StudentWithSubjects>>()
    val studentWithSubjectsResponse: LiveData<List<StudentWithSubjects>> get() = _studentWithSubjectsResponse

    private val _subjectWithStudentsResponse = MutableLiveData<List<SubjectWithStudents>>()
    val subjectWithStudentsResponse: LiveData<List<SubjectWithStudents>> get() = _subjectWithStudentsResponse

    fun insertSchool(school: School) {
        viewModelScope.launch {
            schoolRepository.insertSchool(school)
        }
    }

    fun insertDirector(director: Director) {
        viewModelScope.launch {
            schoolRepository.insertDirector(director)
        }
    }

    fun insertStudent(student: Student) {
        viewModelScope.launch {
            schoolRepository.insertStudent(student)
        }
    }

    fun insertSubject(subject: Subject) {
        viewModelScope.launch {
            schoolRepository.insertSubject(subject)
        }
    }

    fun insertStudentSubjectCrossRef(studentSubjectCrossRef: StudentSubjectCrossRef) {
        viewModelScope.launch {
            schoolRepository.insertStudentSubjectCrossRef(studentSubjectCrossRef)
        }
    }

    fun getSchoolAndDirectorWithSchoolName(schoolName: String) {
        viewModelScope.launch {
            _schoolAndDirectorResponse.value =
                schoolRepository.getSchoolAndDirectorWithSchoolName(schoolName)
        }
    }

    fun getSchoolWithStudentsWithSchoolName(schoolName: String) {
        viewModelScope.launch {
            _schoolWithStudentResponse.value =
                schoolRepository.getSchoolWithStudentsWithSchoolName(schoolName)
        }
    }

    fun getSubjectsOfStudent(studentName: String) {
        viewModelScope.launch {
            _studentWithSubjectsResponse.value = schoolRepository.getSubjectsOfStudent(studentName)
        }
    }

    fun getStudentsOfSubject(subjectName: String) {
        viewModelScope.launch {
            _subjectWithStudentsResponse.value = schoolRepository.getStudentsOfSubject(subjectName)
        }
    }

}