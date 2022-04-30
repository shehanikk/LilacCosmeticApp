package com.example.lilaccosmeticapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_eye.*
import kotlinx.android.synthetic.main.activity_tool.*

class tool : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tool)

        btnHomeTools.setOnClickListener(){
            val intent = Intent(this,home::class.java)
            startActivity(intent)
        }

        btnCategoryTools.setOnClickListener(){
            val intent = Intent(this,catogeries::class.java)
            startActivity(intent)
        }

        btnSaleTools.setOnClickListener(){
            val intent = Intent(this,sales::class.java)
            startActivity(intent)
        }

        btnBackTools.setOnClickListener(){
            val intent = Intent(this,catogeries::class.java)
            startActivity(intent)
        }

        btnCartTools.setOnClickListener(){
            val intent = Intent(this,shoppingcart::class.java)
            startActivity(intent)
        }
        btnFaceBrushes.setOnClickListener(){
            val intent = Intent(this,facebrushes::class.java)
            startActivity(intent)
        }
        btnEyeBrushes.setOnClickListener(){
            val intent = Intent(this,eyebrushes::class.java)
            startActivity(intent)
        }
        btnSponges.setOnClickListener(){
            val intent = Intent(this,sponges::class.java)
            startActivity(intent)
        }

    }
}