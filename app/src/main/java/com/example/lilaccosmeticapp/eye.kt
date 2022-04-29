package com.example.lilaccosmeticapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_eye.*
import kotlinx.android.synthetic.main.activity_eye.btnCartEye
import kotlinx.android.synthetic.main.activity_eyepalettes.*
import kotlinx.android.synthetic.main.activity_lips.*

class eye : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_eye)

        btnHomeEye.setOnClickListener(){
            val intent = Intent(this,home::class.java)
            startActivity(intent)
        }

        btnCategoryEye.setOnClickListener(){
            val intent = Intent(this,catogeries::class.java)
            startActivity(intent)
        }

        btnSaleEye.setOnClickListener(){
            val intent = Intent(this,sales::class.java)
            startActivity(intent)
        }

        btnBackEye.setOnClickListener(){
            val intent = Intent(this,catogeries::class.java)
            startActivity(intent)
        }

        btnCartEye.setOnClickListener(){
            val intent = Intent(this,shoppingcart::class.java)
            startActivity(intent)
        }

        btnEyePalettes.setOnClickListener(){
            val intent = Intent(this,eyepalettes::class.java)
            startActivity(intent)
        }

        btnEyeliner.setOnClickListener(){
            val intent = Intent(this,eyeliner::class.java)
            startActivity(intent)
        }

        btnMascara.setOnClickListener(){
            val intent = Intent(this,mascara::class.java)
            startActivity(intent)
        }

        btnEyePrimer.setOnClickListener(){
            val intent = Intent(this,eyeprimer::class.java)
            startActivity(intent)
        }

    }
}