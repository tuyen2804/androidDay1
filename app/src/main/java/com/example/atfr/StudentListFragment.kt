package com.example.atfr

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.RadioButton

class StudentListFragment : Fragment() {

    private lateinit var listViewStudents: ListView
    private lateinit var btnAddStudent: Button
    private lateinit var btnSearch: Button
    private lateinit var edtSearch: EditText
    private lateinit var radioGreater: RadioButton
    private lateinit var radioLess: RadioButton
    private lateinit var radioEqual: RadioButton
    private lateinit var edtStudentId: EditText
    private lateinit var edtStudentName: EditText
    private lateinit var edtStudentAge: EditText

    private lateinit var adapter: ArrayAdapter<Student>
    private val students = mutableListOf<Student>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_student_list, container, false)

        listViewStudents = view.findViewById(R.id.listViewStudents)
        btnAddStudent = view.findViewById(R.id.btnAddStudent)
        btnSearch = view.findViewById(R.id.btnSearch)
        edtSearch = view.findViewById(R.id.editSearch)
        radioGreater = view.findViewById(R.id.radioGreater)
        radioLess = view.findViewById(R.id.radioLess)
        radioEqual = view.findViewById(R.id.radioEqual)
        edtStudentId = view.findViewById(R.id.edtStudentId)
        edtStudentName = view.findViewById(R.id.edtStudentName)
        edtStudentAge = view.findViewById(R.id.edtStudentAge)

        adapter = ArrayAdapter(requireContext(), android.R.layout.simple_list_item_1, students)
        listViewStudents.adapter = adapter

        // Example data
        for (i in 1..20) {
            students.add(Student("$i", "Student $i", 18 + i))
        }

        listViewStudents.setOnItemClickListener { parent, view, position, id ->
            val selectedStudent = students[position]
            val fragmentB = StudentDetailFragment.newInstance(arrayOf(selectedStudent))
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container_view, fragmentB)
                .addToBackStack(null)
                .commit()
        }

        btnAddStudent.setOnClickListener {
            val studentId = edtStudentId.text.toString()
            val studentName = edtStudentName.text.toString()
            val studentAge = edtStudentAge.text.toString().toIntOrNull() ?: 0

            val newStudent = Student(studentId, studentName, studentAge)
            students.add(newStudent)
            adapter.notifyDataSetChanged()
        }

        btnSearch.setOnClickListener {
            val query = edtSearch.text.toString()
            val filteredStudents = when {
                radioGreater.isChecked -> students.filter { it.age > query.toIntOrNull() ?: 0 }
                radioLess.isChecked -> students.filter { it.age < query.toIntOrNull() ?: 0 }
                else -> students.filter { it.age == query.toIntOrNull() ?: 0 }
            }
            adapter.clear()
            adapter.addAll(filteredStudents)
            adapter.notifyDataSetChanged()

            // Pass filtered students to StudentDetailFragment
            val fragmentB = StudentDetailFragment.newInstance(filteredStudents.toTypedArray())
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container_view, fragmentB)
                .addToBackStack(null)
                .commit()
        }

        return view
    }
}
