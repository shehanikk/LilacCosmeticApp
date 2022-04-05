package com.example.lilaccosmeticapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_catogeries.*
import kotlinx.android.synthetic.main.activity_home.*

class catogeries : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_catogeries)

        btnHome2.setOnClickListener(){
            val intent = Intent(this,home::class.java)
            startActivity(intent)
        }

        btnCatogery2.setOnClickListener(){
            val intent = Intent(this,catogeries::class.java)
            startActivity(intent)
        }

        btnCart2.setOnClickListener(){
            val intent = Intent(this,shoppingcart::class.java)
            startActivity(intent)
        }

        btnLip.setOnClickListener(){
            val intent = Intent(this,lips::class.java)
            startActivity(intent)
        }

        btnEye.setOnClickListener(){
            val intent = Intent(this,eye::class.java)
            startActivity(intent)
        }

        btnFace.setOnClickListener(){
            val intent = Intent(this,face::class.java)
            startActivity(intent)
        }


        btnTools.setOnClickListener(){
            val intent = Intent(this,tool::class.java)
            startActivity(intent)
        }

    }
}