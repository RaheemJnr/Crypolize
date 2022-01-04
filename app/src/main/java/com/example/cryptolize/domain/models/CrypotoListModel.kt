package com.example.cryptolize.domain.models

data class CryptoListModel(
    val id: Int? = null,
    val symbol: String? = null,
    val image: String? = null,
    val current_price: Double? = null,
    val price_change_percentage_24h: Double? = null,
    val total_volume: Double,
)

