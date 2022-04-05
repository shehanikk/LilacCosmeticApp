package com.example.lilaccosmeticapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_catogeries.*
import kotlinx.android.synthetic.main.activity_createaccountpage.*

class createaccountpage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_createaccountpage)

        btnBackCreateAcc.setOnClickListener(){
            val intent = Intent(this,welcomeScreen::class.java)
            startActivity(intent)
        }

        btnHomeCreateAcc.setOnClickListener(){
            val intent = Intent(this,home::class.java)
            startActivity(intent)
        }

        btnCategoryCreateAcc.setOnClickListener(){
            val intent = Intent(this,catogeries::class.java)
            startActivity(intent)
        }

        btnSaleCreateAcc.setOnClickListener(){
            val intent = Intent(this,sales::class.java)
            startActivity(intent)
        }
    }
}