package com.example.lilaccosmeticapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.example.lilaccosmeticapp.adapter.MyProductAdapter
import com.example.lilaccosmeticapp.listeners.ProductLoadListener
import com.example.lilaccosmeticapp.models.product
import com.example.lilaccosmeticapp.utils.SpaceItemDecoration
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.android.synthetic.main.activity_lipstick.*

class lipstick : AppCompatActivity(), ProductLoadListener {

    lateinit var productLoadListener: ProductLoadListener
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lipstick)
        init()
        loadProductFromFirebase()



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

    private fun loadProductFromFirebase() {
        val drinkModels : MutableList<product> = ArrayList()
        FirebaseDatabase.getInstance()
            .getReference("Drink")
            .addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    if (snapshot.exists())
                    {
                        for(drinkSnapshot in snapshot.children)
                        {
                            val drinkModel = drinkSnapshot.getValue(product::class.java)
                            drinkModel!!.key = drinkSnapshot.key
                            drinkModels.add(drinkModel)
                        }

                        productLoadListener.onDrinkLoadSuccess(drinkModels)


                    }

                    else
                        productLoadListener.onDrinkLoadFailed("Drink items not exists")

                }

                override fun onCancelled(error: DatabaseError) {
                    productLoadListener.onDrinkLoadFailed(error.message)
                }

            })
    }
    private fun init(){
        productLoadListener = this
        //cartLoadListener = this

        val gridLayoutManager = GridLayoutManager(this,2)
        rv_lipstick.layoutManager = gridLayoutManager
        rv_lipstick.addItemDecoration(SpaceItemDecoration())
        //recycler_drink.adapter = MyDrinkAdapter(this, productList )

        //btnCart.setOnClickListener{ startActivity(Intent(this,CartActivity::class.java)) }

    }

    override fun onDrinkLoadSuccess(drinkModelList: List<product>?) {
        val adapter = MyProductAdapter(this,drinkModelList!!)
        rv_lipstick.adapter = adapter
    }

    override fun onDrinkLoadFailed(message: String?) {
        Snackbar.make(lipsticLayout,message!!, Snackbar.LENGTH_LONG).show()
    }


}
