package com.example.cryptolize.domain.models

data class CryptoDetailsModel(
    val id: Int? = null,
    val name: String,
    val symbol: String? = null,
    val image: String? = null,
    val current_price: Double? = null,
    val total_volume: Double? = null,
    val market_cap: Long? = null,
    val high_24h: Double? = null,
    val low_24h: Double? = null,
    val price_change_24h: Double? = null,
    val price_change_percentage_24h: Double? = null,
    val total_supply: Double? = null,
    val ath: Long? = null,
    val sparkline_in_7d: SparkLineData,
    )

data class SparkLineData(val price: List<Float>)


//val id: String,
//val symbol: String,
//val name: String,
//val image: String,
//val current_price: Double,
//val market_cap: Long,
//val total_volume: Double,
//val high_24h: Double,
//val low_24h: Double,
//val price_change_24h: Double,
//val price_change_percentage_24h: Double,
//val total_supply: Double,
//val sparkline_in_7d: SparkLineData
//)
//
//data class SparkLineData(val price: List<Float>)