package com.example.listexample.data.dto

import com.example.listexample.model.Product
import com.squareup.moshi.Json

class SpotlightDTO(
    @field:Json(name = "name") private val name: String?,
    @field:Json(name = "bannerURL") val bannerUrl: String?,
    @field:Json(name = "description") val description: String?
) {
    fun transform() = Product(
        name ?: "",
        bannerUrl ?: "",
        description ?: ""
    )
}
