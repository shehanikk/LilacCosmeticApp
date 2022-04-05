package com.example.lilaccosmeticapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlinx.android.synthetic.main.activity_catogeries.*
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

        btnCatagoryHome.setOnClickListener(){
            val intent = Intent(this,catogeries::class.java)
            startActivity(intent)
        }

        btnCartHome.setOnClickListener(){
            val intent = Intent(this,shoppingcart::class.java)
            startActivity(intent)
        }

        btnHomeHome.setOnClickListener(){
            val intent = Intent(this,home::class.java)
            startActivity(intent)
        }

        btnSaleHome.setOnClickListener(){
            val intent = Intent(this,sales::class.java)
            startActivity(intent)
        }

    }

}