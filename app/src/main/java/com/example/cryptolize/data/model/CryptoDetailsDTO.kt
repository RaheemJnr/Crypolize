package com.example.cryptolize.data.model

import com.squareup.moshi.Json

data class CryptoDetailsDTO(
    @Json(name = "id")
    val id: Int? = null,
    @Json(name = "name")
    val name: String,
    @Json(name = "symbol")
    val symbol: String? = null,
    @Json(name = "image")
    val image: String? = null,
    @Json(name = "current_price")
    val current_price: Double? = null,
    @Json(name = "total_volume")
    val total_volume: Double? = null,
    @Json(name = "market_cap")
    val market_cap: Long? = null,
    @Json(name = "high_24h")
    val high_24h: Double? = null,
    @Json(name = "low_24h")
    val low_24h: Double? = null,
    @Json(name = "price_change_24h")
    val price_change_24h: Double? = null,
    @Json(name = "price_change_percentage_24h")
    val price_change_percentage_24h: Double? = null,
    @Json(name = "total_supply")
    val total_supply: Double? = null,
    @Json(name = "ath")
    val ath: Long? = null,
    @Json(name = "sparkline_in_7d")
    val sparkline_in_7d: SparkLineData,
)

data class SparkLineData(
    @Json(name = "price")
    val price: List<Float>
)