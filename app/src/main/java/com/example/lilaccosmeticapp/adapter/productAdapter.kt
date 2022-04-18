package com.example.lilaccosmeticapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import com.example.lilaccosmeticapp.R
import com.example.lilaccosmeticapp.models.product

class productAdapter(private val productList:ArrayList<product>):RecyclerView.Adapter<productAdapter.productViewHolder> (){

    class productViewHolder(itemView:View):RecyclerView.ViewHolder(itemView) {

        var price : TextView=itemView.findViewById(R.id.txtPrice)
        var name  : TextView=itemView.findViewById(R.id.txtName)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): productViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.activity_productlayout,
            parent,false)
        return productViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: productViewHolder, position: Int) {
        val currentitem = productList[position]

        holder.name.text = currentitem.name
        holder.price.text = currentitem.price
    }

    override fun getItemCount(): Int {
       return productList.size
    }

}