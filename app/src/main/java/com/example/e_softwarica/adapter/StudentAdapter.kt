package com.example.e_softwarica.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.e_softwarica.R
import com.example.e_softwarica.model.Student

class StudentAdapter(var context: Context, var lstStudent: ArrayList<Student>) :
    RecyclerView.Adapter<StudentAdapter.StudentViewHolder>() {


    class StudentViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val tvName: TextView
        val tvAddress: TextView
        val tvGender: TextView
        val tvAge: TextView
        val imgProfile: ImageView

        init {
            tvName = view.findViewById(R.id.tvname);
            tvAddress = view.findViewById(R.id.tvaddress);
            tvAge = view.findViewById(R.id.tvage);
            tvGender = view.findViewById(R.id.tvgender);
            imgProfile = view.findViewById(R.id.imgprofile);
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {

        val view = LayoutInflater.from(context).inflate(R.layout.studentlayout, parent, false);
        return StudentViewHolder(
            view
        );

    }

    override fun getItemCount(): Int {
        return lstStudent.size;
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {

        var gender: Int = 0;
        var student: Student = Student();
        student = lstStudent[position];
        holder.tvName.text = student.StudentName;
        holder.tvAddress.text = student.StudentAddress;
        holder.tvAge.text = student.StudentAge.toString();
        holder.tvGender.text = student.StudentGender;

        holder.imgProfile.setOnClickListener {
            Toast.makeText(context, "Hello This is ${holder.tvName.toString()}", Toast.LENGTH_SHORT)
                .show();
        }

        if (student.StudentGender == "Male") {
            gender = R.drawable.imagelogo;
        } else if (student.StudentGender == "Female") {
            gender = R.drawable.imagelogo;
        } else if (student.StudentGender == "Others") {
            gender = R.drawable.imagelogo;
        }

        holder.imgProfile.setImageResource(gender);

        holder.imgProfile.setOnClickListener {
            lstStudent.removeAt(position)
            notifyDataSetChanged()
        }

    }
}