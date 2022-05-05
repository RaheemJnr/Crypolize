package com.raheemjnr.cryptolize.domain.repository.detail

import androidx.annotation.WorkerThread
import com.raheemjnr.cryptolize.data.network.CryptolizeApiCall
import com.raheemjnr.cryptolize.domain.mappers.DetailDTOMapper
import com.raheemjnr.cryptolize.domain.models.detailModel.CoinDetail

class DetailRepoImpl(private val mapper: DetailDTOMapper) : DetailRepo {
    @WorkerThread
    override suspend fun getCoinDetails(coinId: String): CoinDetail? {
        val response =
            CryptolizeApiCall.CRYPTO_SERVICE.getCoinDetails(coinId = coinId)

        return if (response.isSuccessful) {
            val body = response.body()
            val bo = body?.let { mapper.mapToDomainModel(it) }
            bo
        } else {
            null
        }
    }
}

