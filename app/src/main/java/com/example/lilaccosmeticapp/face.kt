package com.example.lilaccosmeticapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_catogeries.*
import kotlinx.android.synthetic.main.activity_face.*
import kotlinx.android.synthetic.main.activity_lips.*

class face : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_face)

        btnHomeFace.setOnClickListener(){
            val intent = Intent(this,home::class.java)
            startActivity(intent)
        }

        btnCategoryFace.setOnClickListener(){
            val intent = Intent(this,catogeries::class.java)
            startActivity(intent)
        }

        btnSaleFace.setOnClickListener(){
            val intent = Intent(this,sales::class.java)
            startActivity(intent)
        }

        btnBackFace.setOnClickListener(){
            val intent = Intent(this,catogeries::class.java)
            startActivity(intent)
        }

        btnCartFace.setOnClickListener(){
            val intent = Intent(this,shoppingcart::class.java)
            startActivity(intent)
        }

        btnFoundation.setOnClickListener(){
            val intent = Intent(this,foundation::class.java)
            startActivity(intent)
        }

        btnBlushe.setOnClickListener(){
            val intent = Intent(this,blushe::class.java)
            startActivity(intent)
        }

        btnBronzer.setOnClickListener(){
            val intent = Intent(this,bronzer::class.java)
            startActivity(intent)
        }

        btnConcealer.setOnClickListener(){
            val intent = Intent(this,concealer::class.java)
            startActivity(intent)
        }

        btnHighlighter.setOnClickListener(){
            val intent = Intent(this,highlighter::class.java)
            startActivity(intent)
        }
    }
}