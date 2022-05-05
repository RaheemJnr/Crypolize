package com.raheemjnr.cryptolize.domain.repository.detail

import com.example.cryptolize.domain.models.detailModel.CoinDetail

interface DetailRepo {
    //details
    suspend fun getCoinDetails(coinId: String): CoinDetail?
}