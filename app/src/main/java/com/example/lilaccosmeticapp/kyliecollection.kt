package com.example.lilaccosmeticapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_catogeries.*
import kotlinx.android.synthetic.main.activity_kyliecollection.*

class kyliecollection : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kyliecollection)

        btnHomeKylie.setOnClickListener(){
            val intent = Intent(this,home::class.java)
            startActivity(intent)
        }

        btnCategoryKylie.setOnClickListener(){
            val intent = Intent(this,catogeries::class.java)
            startActivity(intent)
        }

        btnSaleKylie.setOnClickListener(){
            val intent = Intent(this,sales::class.java)
            startActivity(intent)
        }

        btnBackKylie.setOnClickListener(){
            val intent = Intent(this,home::class.java)
            startActivity(intent)
        }
    }
}