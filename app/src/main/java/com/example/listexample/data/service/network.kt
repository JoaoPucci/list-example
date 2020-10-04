package com.example.listexample.data.service

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

fun getHttpClient(): ProductService = Retrofit.Builder()
    .baseUrl("https://7hgi9vtkdc.execute-api.sa-east-1.amazonaws.com/")
    .addConverterFactory(MoshiConverterFactory.create())
    .build().create(ProductService::class.java)
