package com.example.lilaccosmeticapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lilaccosmeticapp.adapter.productAdapter
import com.example.lilaccosmeticapp.models.product
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_lips.*
import kotlinx.android.synthetic.main.activity_lipstick.*

class lipstick : AppCompatActivity() {

    private lateinit var dbref : DatabaseReference
    private lateinit var lipstickRecyclerview : RecyclerView
    private lateinit var lipstickArrayList : ArrayList<product>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lipstick)

        lipstickRecyclerview = findViewById(R.id.rv_lipstick)
        lipstickRecyclerview.layoutManager = LinearLayoutManager(this)
        lipstickRecyclerview.setHasFixedSize(true)

        lipstickArrayList = arrayListOf<product>()
        getUserData()

        btnHomeLipstick.setOnClickListener(){
            val intent = Intent(this,home::class.java)
            startActivity(intent)
        }

        btnCategoryLipstick.setOnClickListener(){
            val intent = Intent(this,catogeries::class.java)
            startActivity(intent)
        }

        btnSaleLipstick.setOnClickListener(){
            val intent = Intent(this,sales::class.java)
            startActivity(intent)
        }

        btnBackLipstick.setOnClickListener(){
            val intent = Intent(this,lips::class.java)
            startActivity(intent)
        }

        btnCartLipstick.setOnClickListener(){
            val intent = Intent(this,shoppingcart::class.java)
            startActivity(intent)
        }
    }

    private fun getUserData() {

        dbref = FirebaseDatabase.getInstance().getReference("Drink")

        dbref.addValueEventListener(object : ValueEventListener {

            override fun onDataChange(snapshot: DataSnapshot) {

                if (snapshot.exists()){

                    for (userSnapshot in snapshot.children){


                        val user = userSnapshot.getValue(product::class.java)
                        lipstickArrayList.add(user!!)

                    }

                    lipstickRecyclerview.adapter = productAdapter(lipstickArrayList)


                }

            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }


        })

    }
}