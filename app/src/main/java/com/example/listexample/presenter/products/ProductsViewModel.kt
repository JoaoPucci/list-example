package com.example.listexample.presenter.products

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.listexample.data.repository.ProductRepository
import com.example.listexample.model.Product
import kotlinx.coroutines.launch

class ProductsViewModel(private val repository: ProductRepository) : ViewModel() {

    private val _spotlights = MutableLiveData<List<Product>>()
    val spotlights: LiveData<List<Product>>
        get() = _spotlights

    private val _products = MutableLiveData<List<Product>>()
    val products: LiveData<List<Product>>
        get() = _products

    private val _cash = MutableLiveData<Product>()
    val cash: LiveData<Product>
        get() = _cash

    private val _loading = MutableLiveData<Boolean>()
    val loading: LiveData<Boolean>
        get() = _loading

    fun getProducts () {
        viewModelScope.launch {
            _loading.value = true

            with(repository.getAll()) {
                _spotlights.value = this.spotlights
                _products.value = this.products
                _cash.value = this.cash
            }

            _loading.value = false
        }
    }

}
