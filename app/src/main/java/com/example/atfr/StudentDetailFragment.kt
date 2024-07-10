package com.example.atfr

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import java.io.Serializable

private const val ARG_FILTERED_STUDENTS = "filtered_students"


class StudentDetailFragment : Fragment() {

    private lateinit var textViewStudentDetail: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_student_detail, container, false)

        textViewStudentDetail = view.findViewById(R.id.textViewStudentDetail)

        arguments?.let {
            val students = it.getSerializable(ARG_FILTERED_STUDENTS) as? Array<Student>
            val studentDetails = students?.joinToString("\n") { "Student: ${it.name}, Age: ${it.age}" }
            textViewStudentDetail.text = studentDetails ?: "No students found."
        }

        return view
    }

    companion object {
        fun newInstance(filteredStudents: Array<Student>): StudentDetailFragment {
            val fragment = StudentDetailFragment()
            val args = Bundle().apply {
                putSerializable(ARG_FILTERED_STUDENTS, filteredStudents)
            }
            fragment.arguments = args
            return fragment
        }
    }
}
