package com.example.lilaccosmeticapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlinx.android.synthetic.main.activity_home.*

class home : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val gotoLogin = findViewById<Button>(R.id.btnGotoLogin)
        gotoLogin.setOnClickListener(){
            val intent = Intent(this,welcomeScreen::class.java)
            startActivity(intent)

        }

        btnCatagory.setOnClickListener(){
            val intent = Intent(this,catogeries::class.java)
            startActivity(intent)
        }

    }

}