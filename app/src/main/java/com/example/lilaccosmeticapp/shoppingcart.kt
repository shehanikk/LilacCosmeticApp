package com.example.lilaccosmeticapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.lilaccosmeticapp.adapter.MyCartAdapter
import com.example.lilaccosmeticapp.eventbus.UpdateCartEvent
import com.example.lilaccosmeticapp.listeners.CartLoadListener
import com.example.lilaccosmeticapp.models.cart
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.android.synthetic.main.activity_shoppingcart.*
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode
import java.lang.StringBuilder

class shoppingcart : AppCompatActivity() , CartLoadListener {
    var cartLoadListener:CartLoadListener?= null

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
    fun onUpdateCartEvent(event: UpdateCartEvent)
    {
        loadCartFromFirebase()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shoppingcart)
        init()
        loadCartFromFirebase()

        btnPlaceOrder.setOnClickListener(){
            val intent = Intent(this,orderPlacement::class.java)
            startActivity(intent)
          
        }
    }

    private fun loadCartFromFirebase() {
        val cartModels : MutableList<cart> = ArrayList()
        FirebaseDatabase.getInstance()
            .getReference("Cart")
            .child("UNIQUE_USER_ID")
            .addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    for (cartSnapshot in snapshot.children)
                    {
                        val cartModel = cartSnapshot.getValue(cart::class.java)
                        cartModel!!.key = cartSnapshot.key
                        cartModels.add(cartModel)
                    }
                    cartLoadListener!!.onLoadCartSuccess(cartModels)
                }

                override fun onCancelled(error: DatabaseError) {
                    cartLoadListener!!.onLoadCartFailed(error.message)
                }

            })

    }

    private fun init(){
        cartLoadListener = this
        val layoutManager = LinearLayoutManager(this)
        recycler_cart!!.layoutManager = layoutManager
        recycler_cart!!.addItemDecoration(DividerItemDecoration(this,layoutManager.orientation))
        btnBack!!.setOnClickListener{ finish() }
    }

    override fun onLoadCartSuccess(cartModelList: List<cart>) {
        var sum = 0.0
        for (cartModel in cartModelList!!){
            sum+= cartModel!!.totalPrice
        }
        txtTotal.text = StringBuilder("$").append(sum)
        val adapter = MyCartAdapter(this,cartModelList)
        recycler_cart!!.adapter = adapter
    }

    override fun onLoadCartFailed(message: String?) {
        Snackbar.make(cartLayout,message!!, Snackbar.LENGTH_LONG).show()

    }
}