package com.example.e_softwarica.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import com.example.e_softwarica.Object.Studentobject
import com.example.e_softwarica.R
import com.example.e_softwarica.model.Student

class AddstudentFragment : Fragment() {

    private lateinit var etfullname: EditText
    private lateinit var etage: EditText
    private lateinit var rdogender: RadioGroup
    private lateinit var etaddress: EditText
    private lateinit var rdoMale: RadioButton
    private lateinit var rdoFemale: RadioButton
    private lateinit var rdoOther: RadioButton
    private lateinit var btnsave: Button

    var gender: String = "";


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_addstudent, container, false)


        etfullname = view.findViewById(R.id.etfullname)
        etage = view.findViewById(R.id.etage)
        rdogender = view.findViewById(R.id.rdogender)
        etaddress = view.findViewById(R.id.etaddress)
        btnsave = view.findViewById(R.id.btnsave)
        rdoFemale = view.findViewById(R.id.rdofemale);
        rdoMale = view.findViewById(R.id.rdomale);
        rdoOther = view.findViewById(R.id.rdoothers);

        btnsave.setOnClickListener {
            if (etfullname.text.isEmpty()) {
                etfullname.error = "Name should not be empty !"
            } else if (etage.text.isEmpty()) {
                etage.error = "Age should not be empty !"
            } else if (etaddress.text.isEmpty()) {
                etaddress.error = "Address Should not be empty !"
            } else if (rdoMale.isChecked && rdoFemale.isChecked && rdoOther.isChecked) {
                Toast.makeText(context, "Gender must be specified", Toast.LENGTH_LONG).show()
            } else {

                var name = etfullname.text.toString()
                var age = etage.text.toString().toInt()
                var address = etaddress.text.toString()

                Studentobject.setStudent(Student(name, age, gender, address));

                Toast.makeText(context, "Data saved Successfully!!", Toast.LENGTH_LONG).show()

            }
        }



            rdogender.setOnCheckedChangeListener(object : RadioGroup.OnCheckedChangeListener {
            override fun onCheckedChanged(group: RadioGroup?, checkedId: Int) {
                when (checkedId) {
                    R.id.rdomale -> {
                        gender = "Male";
                    }
                    R.id.rdofemale -> {
                        gender = "Female";
                    }
                    R.id.rdoothers -> {
                        gender = "Others";
                    }
                }
            }

        });
        return view
    }
}

