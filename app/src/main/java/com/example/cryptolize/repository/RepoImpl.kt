package com.example.cryptolize.repository

import com.example.cryptolize.data.DTOMapper
import com.example.cryptolize.data.network.CryptolizeApiCall
import com.example.cryptolize.domain.models.CryptoListModel

class CryptolizeRepoImpl(val mapper: DTOMapper) : CryptolizeRepo {

    override suspend fun getGitHubDataList(
        page: Int, pageSize: Int
    ): List<CryptoListModel> {
        val response = CryptolizeApiCall.CRYPTO_LIST_SERVICE.getAllCrypto()
        if (response.isSuccessful) {
            val body = response.body()
            return mapper.toDomainList(body!!)
        } else {
            return emptyList()
        }
    }
}