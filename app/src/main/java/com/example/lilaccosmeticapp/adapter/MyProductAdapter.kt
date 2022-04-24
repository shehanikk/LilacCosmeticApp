package com.example.lilaccosmeticapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.Glide.init
import com.example.lilaccosmeticapp.R
import com.example.lilaccosmeticapp.eventbus.UpdateCartEvent
import com.example.lilaccosmeticapp.listeners.CartLoadListener
import com.example.lilaccosmeticapp.listeners.RecyclerClickListener
import com.example.lilaccosmeticapp.models.cart
import com.example.lilaccosmeticapp.models.product
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import org.greenrobot.eventbus.EventBus
import java.lang.StringBuilder

class MyProductAdapter(private val context : Context,private val proList : List<product>,private val cartListener: CartLoadListener): RecyclerView.Adapter<MyProductAdapter.MyProductViewHolder>() {

    class MyProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener {
        var imageView: ImageView? = null
        var txtName: TextView? = null
        var txtPrice: TextView? = null

        private var clickListener: RecyclerClickListener? = null

        fun setClickListener(clickListener: RecyclerClickListener) {
            this.clickListener = clickListener;
        }

        init {
            imageView = itemView.findViewById(R.id.imageView) as ImageView
            txtName = itemView.findViewById(R.id.txtName) as TextView;
            txtPrice = itemView.findViewById(R.id.txtPrice) as TextView;

            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            clickListener!!.onItemClickListener(v, adapterPosition)
        }

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyProductViewHolder {
        return MyProductViewHolder(
            LayoutInflater.from(context)
                .inflate(R.layout.product_layout, parent, false)
        )
    }

    override fun onBindViewHolder(holder: MyProductViewHolder, position: Int) {
        Glide.with(context)
            .load(proList[position].image)
            .into(holder.imageView!!)
        holder.txtName!!.text = StringBuilder().append(proList[position].name)
        holder.txtPrice!!.text = StringBuilder("$").append(proList[position].price)

        holder.setClickListener(object : RecyclerClickListener {
            override fun onItemClickListener(view: View?, position: Int) {
                addToCart(proList[position])
            }
        })
    }

    private fun addToCart(product: product) {
        val userCart = FirebaseDatabase.getInstance()
            .getReference("Cart")
            .child("UNIQUE_USER_ID")

        userCart.child(product.key!!)
            .addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    if (snapshot.exists())
                    {
                        val cartModel = snapshot.getValue(cart::class.java)
                        val updateData: MutableMap<String,Any> = HashMap()
                        cartModel!!.quantity = cartModel!!.quantity+1;
                        updateData["quantity"] = cartModel!!.quantity
                        updateData["totalPrice"] = cartModel!!.quantity * cartModel.price!!.toFloat()


                        userCart.child(product.key!!)
                            .updateChildren(updateData)
                            .addOnSuccessListener {
                                EventBus.getDefault().postSticky(UpdateCartEvent())
                                cartListener.onLoadCartFailed("Success add to cart")
                            }
                            .addOnFailureListener{ e-> cartListener.onLoadCartFailed(e.message)}
                    }
                    else
                    {
                        val cartModel = cart()
                        cartModel.key = product.key
                        cartModel.name = product.name
                        cartModel.image = product.image
                        cartModel.price = product.price
                        cartModel.quantity = 1
                        cartModel.totalPrice = product.price!!.toFloat()

                        userCart.child(product.key!!)
                            .setValue(cartModel)
                            .addOnSuccessListener {
                                EventBus.getDefault().postSticky(UpdateCartEvent())
                                cartListener.onLoadCartFailed("Success add to cart")
                            }
                            .addOnFailureListener{ e-> cartListener.onLoadCartFailed(e.message)}

                    }
                }

                override fun onCancelled(error: DatabaseError) {
                    cartListener.onLoadCartFailed(error.message)
                }

            })
    }

    override fun getItemCount(): Int {
        return proList.size
    }

}