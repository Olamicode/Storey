package com.olamachia.multipletableroom

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.olamachia.multipletableroom.viewmodel.SchoolViewModel
import com.olamachia.utils.SchoolResourceProvider
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val viewModel: SchoolViewModel by viewModels()

    companion object {
        const val MAIN_ACTIVITY_TAG = "MAIN_ACTIVITY_TAG"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        SchoolResourceProvider.schools.forEach { school ->
            viewModel.insertSchool(school)
        }

        SchoolResourceProvider.directors.forEach { director ->
            viewModel.insertDirector(director)
        }

        SchoolResourceProvider.subjects.forEach { subject ->
            viewModel.insertSubject(subject)
        }

        SchoolResourceProvider.students.forEach { student ->
            viewModel.insertStudent(student)
        }

        SchoolResourceProvider.studentSubjectRelations.forEach { studentSubjectCrossRef ->
            viewModel.insertStudentSubjectCrossRef(studentSubjectCrossRef)
        }

        viewModel.getSubjectsOfStudent(SchoolResourceProvider.students.first().studentName)

        viewModel.studentWithSubjectsResponse.observe(this, {
           it.first().subjects.forEach { Subject ->
               Log.d(MAIN_ACTIVITY_TAG, Subject.subjectName)
           }
        })

    }
}