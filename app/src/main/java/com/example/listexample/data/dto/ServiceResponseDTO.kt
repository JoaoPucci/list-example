package com.example.listexample.data.dto

import com.example.listexample.model.Product
import com.example.listexample.model.ServiceResponse
import com.squareup.moshi.Json

class ServiceResponseDTO(
    @field:Json(name = "spotlight") private val spotlights: List<SpotlightDTO>?,
    @field:Json(name = "products") private val products: List<ProductDTO>?,
    @field:Json(name = "cash") private val cash: CashDTO?
) {
    fun transform() = ServiceResponse(
        spotlights?.map { it.transform() } ?: listOf(),
        products?.map { it.transform() } ?: listOf(),
        cash?.transform() ?: Product()
    )
}
