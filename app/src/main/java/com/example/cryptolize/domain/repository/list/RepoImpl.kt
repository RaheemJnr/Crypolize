package com.example.cryptolize.domain.repository.list

import androidx.annotation.WorkerThread
import com.example.cryptolize.data.ListDTOMapper
import com.example.cryptolize.data.network.CryptolizeApiCall
import com.example.cryptolize.domain.models.Crypto
import com.example.cryptolize.domain.repository.ListRepo


class ListRepoImpl(private val mapper: ListDTOMapper) : ListRepo {

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

}