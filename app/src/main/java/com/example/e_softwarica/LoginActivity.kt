package com.example.e_softwarica

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class LoginActivity : AppCompatActivity() {

    private lateinit var etusername: EditText
    private lateinit var etpassword: EditText
    private lateinit var btnlogin: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        etpassword = findViewById(R.id.etpassword)
        etusername = findViewById(R.id.etusername)
        btnlogin = findViewById(R.id.btnlogin)

        btnlogin.setOnClickListener {
            if (TextUtils.isEmpty(etusername.text.toString())) {
                etusername.error = "Enter Username";
                etusername.requestFocus();
            } else if (TextUtils.isEmpty(etpassword.text.toString())) {
                etpassword.error = "Enter Password";
                etpassword.requestFocus();
            } else {
                if (etusername.text.toString() == "softwarica" && etpassword.text.toString() == "coventry") {
                    val intent: Intent = Intent(this, DashboardActivity::class.java)
                    startActivity(intent)
                } else {
                    Toast.makeText(
                        this,
                        "Either Usernam or Password Doesnot Match",
                        Toast.LENGTH_SHORT
                    ).show();
                }
            }
        }
    }
}