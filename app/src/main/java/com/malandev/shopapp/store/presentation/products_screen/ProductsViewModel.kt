package com.malandev.shopapp.store.presentation.products_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.malandev.shopapp.store.domain.repository.ProductsRepository
import com.malandev.shopapp.store.presentation.util.sendEvent
import com.malandev.shopapp.util.Event
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductsViewModel @Inject constructor(
    private val productsRepository: ProductsRepository
):ViewModel() {

    private val _state = MutableStateFlow(ProductsViewState())
    val state = _state.asStateFlow()

    init {
        getProducts()
    }

    private fun getProducts(){
        viewModelScope.launch {
            _state.update {
                it.copy(isLoading =  true)
            }
            productsRepository.getProducts()
                .onRight { prodcts->
                    _state.update {
                        it.copy(products = prodcts)
                    }
                }
                .onLeft {error->
                    _state.update {
                        it.copy(
                            error = error.error.message
                        )
                    }
                    sendEvent(Event.Toast(error.error.message))
                }
            _state.update {
                it.copy(isLoading = false)
            }
        }
    }
}