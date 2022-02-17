package com.example.cryptolize.domain.repository

import androidx.annotation.WorkerThread
import com.example.cryptolize.data.DTOMapper
import com.example.cryptolize.data.network.CryptolizeApiCall
import com.example.cryptolize.domain.models.CryptoListModel

class CryptolizeRepoImpl(private val mapper: DTOMapper) : CryptolizeRepo {

    @WorkerThread
    override suspend fun getGitHubDataList(
        page: Int, pageSize: Int
    ): List<CryptoListModel> {
        val response = CryptolizeApiCall.CRYPTO_LIST_SERVICE.getAllCrypto(page)
        return if (response.isSuccessful && !response.body().isNullOrEmpty()) {
            val body = response.body()
            val bodyList = mapper.toDomainList(body!!)
            bodyList
        } else {
            emptyList()
        }
    }

}