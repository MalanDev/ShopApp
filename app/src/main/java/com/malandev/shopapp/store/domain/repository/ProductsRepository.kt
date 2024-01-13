package com.malandev.shopapp.store.domain.repository

import arrow.core.Either
import com.malandev.shopapp.store.domain.model.NetworkError
import com.malandev.shopapp.store.domain.model.Product

interface ProductsRepository {

    suspend fun getProducts():Either<NetworkError,List<Product>,>
}