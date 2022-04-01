package com.example.cryptolize.domain.repository

import androidx.annotation.WorkerThread
import com.example.cryptolize.data.ListDTOMapper
import com.example.cryptolize.data.network.CryptolizeApiCall
import com.example.cryptolize.domain.models.Crypto
import com.example.cryptolize.domain.models.detailModel.CoinDetail

class CryptolizeRepoImpl(private val mapper: ListDTOMapper) : CryptolizeRepo {

    @WorkerThread
    override suspend fun getCryptoList(
        page: Int, pageSize: Int
    ): List<Crypto> {
        val response = CryptolizeApiCall.CRYPTO_SERVICE.getCryptoList(page)
        return if (response.isSuccessful && !response.body().isNullOrEmpty()) {
            val body = response.body()
            val bodyList = mapper.toDomainList(body!!)
            bodyList
        } else {
            emptyList()
        }
    }

    @WorkerThread
    override suspend fun getCoinDetails(coinId: String): List<CoinDetail> {
        val response = CryptolizeApiCall.CRYPTO_SERVICE.getCoinDetails(coinId = coinId)
        return if (response.isSuccessful && !response.body().isNullOrEmpty()){
            val body = response.body()
            val bo = mapper.toDomainList(body)
            bo
        }else{
            emptyList()
        }


    }

}