package com.malandev.shopapp.store.domain.model

data class Product(
    val id:Int,
    val description:String,
    val title:String,
    val price:Double,
    val category:String,
    val image:String,
    val rating:Rating,
)

data class Rating(
    val rate:Double,
    val count:Int,
)
