package com.example.lilaccosmeticapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_createaccountpage.*

class createaccountpage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_createaccountpage)

        btnSignUp.setOnClickListener(){
            Toast.makeText(this, "Fill the above fields to register", Toast.LENGTH_SHORT).show()

            // todo validation for register to the account
        }
    }
}