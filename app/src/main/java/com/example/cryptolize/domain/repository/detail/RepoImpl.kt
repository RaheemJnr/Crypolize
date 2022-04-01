package com.example.cryptolize.domain.repository.detail

import androidx.annotation.WorkerThread
import com.example.cryptolize.data.DetailDTOMapper
import com.example.cryptolize.data.network.CryptolizeApiCall
import com.example.cryptolize.domain.models.detailModel.CoinDetail

class DetailRepoImpl(private val mapper: DetailDTOMapper) : DetailRepo {
    @WorkerThread
    override suspend fun getCoinDetails(coinId: String): List<CoinDetail> {
        val response = CryptolizeApiCall.CRYPTO_SERVICE.getCoinDetails(coinId = coinId)
        return if (response.isSuccessful && !response.body().isNullOrEmpty()) {
            val body = response.body()
            val bo = mapper.toDomainList(body!!)
            bo
        } else {
            emptyList()
        }
    }

}