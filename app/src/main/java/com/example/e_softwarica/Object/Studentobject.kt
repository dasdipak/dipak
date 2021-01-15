package com.example.e_softwarica.Object

import com.example.e_softwarica.model.Student

object Studentobject {
    var lstStudent = arrayListOf<Student>()

    fun getStudent(): ArrayList<Student> {
        return lstStudent;
    }

    fun setStudent(student: Student) {
        lstStudent.add(student);
    }
}