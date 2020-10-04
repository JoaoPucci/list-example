package com.example.listexample.data.repository

import com.example.listexample.data.service.ProductService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ProductRepositoryImpl(private val service: ProductService) : ProductRepository {
    override suspend fun getAll() = withContext(Dispatchers.IO) {
        service.getAll().transform()
    }
}
