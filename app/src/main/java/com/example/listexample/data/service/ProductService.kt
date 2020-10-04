package com.example.listexample.data.service

import com.example.listexample.data.dto.ServiceResponseDTO
import retrofit2.http.GET

interface ProductService {

    @GET("sandbox/products")
    suspend fun getAll(): ServiceResponseDTO

}
