package com.example.cryptolize.domain.repository

import com.example.cryptolize.domain.models.Crypto
import com.example.cryptolize.domain.models.detailModel.CoinDetail

/**
 * interface to get our data
 */
interface CryptolizeRepo {
    //list
    suspend fun getCryptoList(page: Int, pageSize: Int): List<Crypto>

    //details
    suspend fun getCoinDetails(coinId: String): List<CoinDetail>
}