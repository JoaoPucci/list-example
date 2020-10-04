package com.example.listexample.data.dto

import com.example.listexample.model.Product
import com.squareup.moshi.Json

class CashDTO(
    @field:Json(name = "title") private val title: String?,
    @field:Json(name = "bannerURL") val bannerUrl: String?,
    @field:Json(name = "description") val description: String?
) {
    fun transform() = Product(
        title ?: "",
        bannerUrl ?: "",
        description ?: ""
    )
}
