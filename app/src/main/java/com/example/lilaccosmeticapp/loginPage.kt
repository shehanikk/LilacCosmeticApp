package com.example.lilaccosmeticapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class loginPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_page)

        val backtowelcome = findViewById<Button>(R.id.btnBacktoWelcome)
        backtowelcome.setOnClickListener() {
            val intent = Intent(this, welcomeScreen::class.java)
            startActivity(intent)
        }

        val gotoHome = findViewById<Button>(R.id.btnHome)
        backtowelcome.setOnClickListener() {
            val intent = Intent(this, home::class.java)
            startActivity(intent)

        }

        val gotoCategories = findViewById<Button>(R.id.btnCategories)
        gotoCategories.setOnClickListener() {
            val intent = Intent(this, catogeries::class.java)
            startActivity(intent)
        }
    }
}