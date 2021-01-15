package com.example.e_softwarica.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.e_softwarica.Object.Studentobject
import com.example.e_softwarica.R
import com.example.e_softwarica.adapter.StudentAdapter
import com.example.e_softwarica.model.Student

class HomeFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView;

    companion object {
        @JvmStatic
        var lstStudent = arrayListOf<Student>();
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home, container, false);
        recyclerView = view.findViewById(R.id.recyclerView);



        val adapter = StudentAdapter(context!!,Studentobject.getStudent())
        loadStudentdata()
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = adapter
        return view

        return view;
    }

    fun loadStudentdata(){
        if (Studentobject.getStudent().isEmpty()){
            Studentobject.setStudent(Student("dipak",21,"Male","ktm"))
        }
        else{
            Studentobject.getStudent()
        }
    }

}