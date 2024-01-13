package com.malandev.shopapp.store.presentation.products_screen

import com.malandev.shopapp.store.domain.model.NetworkError
import com.malandev.shopapp.store.domain.model.Product

data class ProductsViewState (
    val isLoading: Boolean = false,
    val products: List<Product> = emptyList(),
    val error: String? = null,
)