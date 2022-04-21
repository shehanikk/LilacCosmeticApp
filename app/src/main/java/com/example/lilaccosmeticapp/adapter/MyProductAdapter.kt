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
import com.example.lilaccosmeticapp.listeners.RecyclerClickListener
import com.example.lilaccosmeticapp.models.product
import java.lang.StringBuilder

class MyProductAdapter(private val context : Context,private val proList : List<product>): RecyclerView.Adapter<MyProductAdapter.MyProductViewHolder>() {

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
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        return proList.size
    }

}