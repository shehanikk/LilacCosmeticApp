package com.example.lilaccosmeticapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class thankyoupage : AppCompatActivity() {

    lateinit var handler: Handler
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_thankyoupage)

        handler = Handler()
        handler.postDelayed({

            val intent = Intent(this,home::class.java)
            startActivity(intent)
            finish()
        },2000)
    }

    }
