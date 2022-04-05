package com.example.lilaccosmeticapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login_page.*

class loginPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_page)

        val backtowelcome = findViewById<Button>(R.id.btnBacktoWelcome)
        backtowelcome.setOnClickListener() {
            val intent = Intent(this, welcomeScreen::class.java)
            startActivity(intent)
            finish()
        }

        val gotoHome = findViewById<Button>(R.id.btnHome)
        backtowelcome.setOnClickListener() {
            val intent = Intent(this, welcomeScreen::class.java)
            startActivity(intent)

        }

        val gotoCategories = findViewById<Button>(R.id.btnCategories)
        gotoCategories.setOnClickListener() {
            val intent = Intent(this, catogeries::class.java)
            startActivity(intent)
        }

        btnLoginSave.setOnClickListener(){
            Toast.makeText(this, "Fill the above fields first", Toast.LENGTH_SHORT).show()

            // todo empty field validation need to be entered here
        }
    }

}