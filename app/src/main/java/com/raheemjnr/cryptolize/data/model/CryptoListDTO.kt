package com.raheemjnr.cryptolize.data.model

import com.squareup.moshi.Json

data class CryptoListDTO(
    @Json(name = "id")
    val id: String? = null,
    @Json(name = "symbol")
    val symbol: String? = null,
    @Json(name = "image")
    val image: String? = null,
    @Json(name = "current_price")
    val current_price: Double? = null,
    @Json(name = "price_change_percentage_24h")
    val price_change_percentage_24h: Double? = null,
    @Json(name = "total_volume")
    val total_volume: Double,
)