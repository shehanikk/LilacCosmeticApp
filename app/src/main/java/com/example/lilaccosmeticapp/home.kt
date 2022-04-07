package com.example.lilaccosmeticapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import kotlinx.android.synthetic.main.activity_home.*

class home : AppCompatActivity() {
    lateinit var viewPager: ViewPager2
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

         viewPager = findViewById(R.id.view_pagerHome)

        val fragments: ArrayList<Fragment> = arrayListOf(
            Home1Fragment(),
            Home2Fragment(),
            Home3Fragment()
        )

        val adapter = ViewPagerHomeAdapter(fragments, this)
        viewPager.adapter = adapter


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

    override fun onBackPressed() {
        if(viewPager.currentItem == 0){
            super.onBackPressed()
        }else{
            viewPager.currentItem = viewPager.currentItem - 1

        }
    }

}