package com.raheemjnr.cryptolize.data.repository.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Crypto_keys_table")
data class CryptoKeysEntity(
    @PrimaryKey
    val id: String,
    val prevPage: Int?,
    val nextPage: Int?
)