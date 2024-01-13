package com.malandev.shopapp.store.data.repository

import arrow.core.Either
import com.malandev.shopapp.store.data.mapper.toNetworkError
import com.malandev.shopapp.store.data.remote.ProductsApi
import com.malandev.shopapp.store.domain.model.NetworkError
import com.malandev.shopapp.store.domain.model.Product
import com.malandev.shopapp.store.domain.repository.ProductsRepository
import javax.inject.Inject

class ProductRepositoryImpl @Inject constructor(
    private val productsApi: ProductsApi
): ProductsRepository {
    override suspend fun getProducts(): Either<NetworkError, List<Product>> {
       return Either.catch {
            productsApi.getProducts();
        }.mapLeft {
            it.toNetworkError()
       }
    }

}