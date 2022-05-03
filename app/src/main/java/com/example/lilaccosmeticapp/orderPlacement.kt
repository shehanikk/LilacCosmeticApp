package com.example.lilaccosmeticapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import com.example.lilaccosmeticapp.databinding.ActivityOrderPlacementBinding
import com.example.lilaccosmeticapp.models.Users
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_mascara.*
import kotlinx.android.synthetic.main.activity_order_placement.*

class orderPlacement : AppCompatActivity(){

    private lateinit var binding: ActivityOrderPlacementBinding
    private lateinit var database : DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order_placement)
         binding = ActivityOrderPlacementBinding.inflate(layoutInflater)
        setContentView(binding.root)

        btnBackYourdetails.setOnClickListener(){
            val intent = Intent(this,shoppingcart::class.java)
            startActivity(intent)
        }


        binding.btnConfirm.setOnClickListener(){

            val fullname = binding.inputName.text.toString()
            val address = binding.inputAddress.text.toString()
            val cnumber = binding.inputContactNo.text.toString()

            database = FirebaseDatabase.getInstance().getReference("Users")
            val User = Users(fullname,address,cnumber)
            database.child(fullname).setValue(User).addOnSuccessListener {

                binding.inputName.text?.clear()
                binding.inputAddress.text?.clear()
                binding.inputContactNo.text?.clear()

                Toast.makeText(this,"Successfuly Saved",Toast.LENGTH_SHORT).show()
            }.addOnFailureListener{
                Toast.makeText(this,"Saving Faliled",Toast.LENGTH_SHORT).show()
            }
        }
    }
}