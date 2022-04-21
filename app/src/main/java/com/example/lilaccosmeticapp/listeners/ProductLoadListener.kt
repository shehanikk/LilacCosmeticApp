package com.example.lilaccosmeticapp.listeners

import com.example.lilaccosmeticapp.models.product

interface ProductLoadListener {
    fun onDrinkLoadSuccess(drinkModelList: List<product>?)
    fun onDrinkLoadFailed(message:String?)
}