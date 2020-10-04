package com.example.listexample.data.repository

import com.example.listexample.model.ServiceResponse

interface ProductRepository {
    suspend fun getAll(): ServiceResponse
}
