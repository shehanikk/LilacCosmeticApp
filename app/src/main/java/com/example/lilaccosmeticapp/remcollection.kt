package com.example.lilaccosmeticapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_kyliecollection.*
import kotlinx.android.synthetic.main.activity_remcollection.*

class remcollection : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_remcollection)

        btnHomeRem.setOnClickListener(){
            val intent = Intent(this,home::class.java)
            startActivity(intent)
        }

        btnCategoryRem.setOnClickListener(){
            val intent = Intent(this,catogeries::class.java)
            startActivity(intent)
        }

        btnSaleRem.setOnClickListener(){
            val intent = Intent(this,sales::class.java)
            startActivity(intent)
        }

        btnBackRem.setOnClickListener(){
            val intent = Intent(this,home::class.java)
            startActivity(intent)
        }
        btnKylieCartAdd7.setOnClickListener(){
            val intent = Intent(this,eyepalettes::class.java)
            startActivity(intent)
        }
        btnKylieCartAdd8.setOnClickListener(){
            val intent = Intent(this,highlighter::class.java)
            startActivity(intent)
        }
        btnKylieCartAdd9.setOnClickListener(){
            val intent = Intent(this,eyeliner::class.java)
            startActivity(intent)
        }
    }
}