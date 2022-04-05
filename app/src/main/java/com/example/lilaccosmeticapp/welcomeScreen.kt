package com.example.lilaccosmeticapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlinx.android.synthetic.main.activity_catogeries.*
import kotlinx.android.synthetic.main.activity_welcome_screen.*

class welcomeScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome_screen)

        val closetoHome = findViewById<Button>(R.id.btnClosetoHome)
        closetoHome.setOnClickListener(){
            val intent = Intent(this,home::class.java)
            startActivity(intent)
        }
        val loginPageact = findViewById<Button>(R.id.btnLogin)
        loginPageact.setOnClickListener(){
            val intent = Intent(this,loginPage::class.java)
            startActivity(intent)
        }

        val gotoRegistration = findViewById<Button>(R.id.btnCreateAccount)
        gotoRegistration.setOnClickListener(){
            val intent = Intent(this,createaccountpage::class.java)
            startActivity(intent)
        }

        btnHomeWelcome.setOnClickListener(){
            val intent = Intent(this,home::class.java)
            startActivity(intent)
        }

        btnCategoryWelcome.setOnClickListener(){
            val intent = Intent(this,catogeries::class.java)
            startActivity(intent)
        }

        btnSaleWelcome.setOnClickListener(){
            val intent = Intent(this,sales::class.java)
            startActivity(intent)
        }
    }
}