package com.malandev.shopapp.store.data.remote

import com.malandev.shopapp.store.domain.model.Product
import retrofit2.http.GET

interface ProductsApi {

    @GET("products")
    suspend fun getProducts():List<Product>
}