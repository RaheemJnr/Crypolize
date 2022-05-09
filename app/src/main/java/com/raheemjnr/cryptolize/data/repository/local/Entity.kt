package com.raheemjnr.cryptolize.data.repository.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "local_crypto_table")
data class CryptoEntity(
    @PrimaryKey
    val id: String?,
    val symbol: String?,
    val image: String?,
    val current_price: Double?,
    val price_change_percentage_24h: Double?,
    val total_volume: Double,
)