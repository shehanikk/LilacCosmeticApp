package com.example.lilaccosmeticapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.example.lilaccosmeticapp.adapter.MyProductAdapter
import com.example.lilaccosmeticapp.eventbus.UpdateCartEvent
import com.example.lilaccosmeticapp.listeners.CartLoadListener
import com.example.lilaccosmeticapp.listeners.ProductLoadListener
import com.example.lilaccosmeticapp.models.cart
import com.example.lilaccosmeticapp.models.product
import com.example.lilaccosmeticapp.utils.SpaceItemDecoration
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.android.synthetic.main.activity_lipstick.*
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

class lipstick : AppCompatActivity(), ProductLoadListener, CartLoadListener {

    lateinit var productLoadListener: ProductLoadListener
    lateinit var cartLoadListener: CartLoadListener

    override fun onStart() {
        super.onStart()
        EventBus.getDefault().register(this)
    }

    override fun onStop() {
        super.onStop()
        if (EventBus.getDefault().hasSubscriberForEvent(UpdateCartEvent::class.java))
            EventBus.getDefault().removeStickyEvent(UpdateCartEvent::class.java)
        EventBus.getDefault().unregister(this)
    }

    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    fun onUpdateCartEvent(event:UpdateCartEvent)
    {
        countCartFromFirebase()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lipstick)
        init()
        loadProductFromFirebase()
        countCartFromFirebase()



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
    private fun countCartFromFirebase() {
        val cartModels : MutableList<cart> = ArrayList()
        FirebaseDatabase.getInstance()
            .getReference("Cart")
            .child("UNIQUE_USER_ID")
            .addListenerForSingleValueEvent(object :ValueEventListener{
                override fun onDataChange(snapshot: DataSnapshot) {
                    for (cartSnapshot in snapshot.children)
                    {
                        val cartModel = cartSnapshot.getValue(cart::class.java)
                        cartModel!!.key = cartSnapshot.key
                        cartModels.add(cartModel)
                    }
                    cartLoadListener.onLoadCartSuccess(cartModels)
                }

                override fun onCancelled(error: DatabaseError) {
                    cartLoadListener.onLoadCartFailed(error.message)
                }

            })
    }

    private fun loadProductFromFirebase() {
        val drinkModels : MutableList<product> = ArrayList()
        FirebaseDatabase.getInstance()
            .getReference("Product")
            .child("lipsticks")
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
        cartLoadListener = this

        val gridLayoutManager = GridLayoutManager(this,2)
        rv_lipstick.layoutManager = gridLayoutManager
        rv_lipstick.addItemDecoration(SpaceItemDecoration())
        //recycler_drink.adapter = MyDrinkAdapter(this, productList )

        //btnCart.setOnClickListener{ startActivity(Intent(this,CartActivity::class.java)) }

    }

    override fun onDrinkLoadSuccess(drinkModelList: List<product>?) {
        val adapter = MyProductAdapter(this,drinkModelList!!, cartLoadListener )
        rv_lipstick.adapter = adapter
    }

    override fun onDrinkLoadFailed(message: String?) {
        Snackbar.make(lipsticLayout,message!!, Snackbar.LENGTH_LONG).show()
    }
    override fun onLoadCartSuccess(cartModelList: List<cart>) {
        var cartSum = 0
        for (cartModel in cartModelList!!) cartSum+= cartModel!!.quantity
        //badge!!.setNumber(cartSum)
    }

    override fun onLoadCartFailed(message: String?) {
        Snackbar.make(lipsticLayout,message!!,Snackbar.LENGTH_LONG).show()

    }


}
