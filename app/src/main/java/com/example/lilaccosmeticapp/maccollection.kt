package com.example.lilaccosmeticapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_kyliecollection.*
import kotlinx.android.synthetic.main.activity_maccollection.*

class maccollection : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maccollection)

        btnHomeMac.setOnClickListener(){
            val intent = Intent(this,home::class.java)
            startActivity(intent)
        }

        btnCategoryMac.setOnClickListener(){
            val intent = Intent(this,catogeries::class.java)
            startActivity(intent)
        }

        btnSaleMac.setOnClickListener(){
            val intent = Intent(this,sales::class.java)
            startActivity(intent)
        }

        btnBackMac.setOnClickListener(){
            val intent = Intent(this,home::class.java)
            startActivity(intent)
        }
        btnKylieCartAdd2.setOnClickListener(){
            val intent = Intent(this,lipstick::class.java)
            startActivity(intent)
        }
        btnKylieCartAdd3.setOnClickListener(){
            val intent = Intent(this,eyepalettes::class.java)
            startActivity(intent)
        }
        btnKylieCartAdd6.setOnClickListener(){
            val intent = Intent(this,foundation::class.java)
            startActivity(intent)
        }

    }
}