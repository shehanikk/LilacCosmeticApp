package com.example.lilaccosmeticapp.listeners

import com.example.lilaccosmeticapp.models.cart

interface CartLoadListener {
    fun onLoadCartSuccess(cartModelList: List<cart>)
    fun onLoadCartFailed(message:String?)
}