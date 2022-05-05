package com.raheemjnr.cryptolize.domain.repository.detail

import com.raheemjnr.cryptolize.domain.models.detailModel.CoinDetail


interface DetailRepo {
    //details
    suspend fun getCoinDetails(coinId: String): CoinDetail?
}