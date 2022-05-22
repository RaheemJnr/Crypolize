package com.raheemjnr.cryptolize.domain.repository.list

import android.content.Context
import androidx.annotation.WorkerThread
import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.raheemjnr.cryptolize.data.repository.local.CryptoDatabase
import com.raheemjnr.cryptolize.data.repository.local.entity.CryptoEntity
import com.raheemjnr.cryptolize.data.repository.network.CryptoRemoteMediator
import com.raheemjnr.cryptolize.data.repository.network.CryptolizeApiCall
import com.raheemjnr.cryptolize.domain.mappers.MapDTOtoDbEntity
import kotlinx.coroutines.flow.Flow


class ListRepoImpl(
    context: Context
) : ListRepo {

//        @WorkerThread
//    override suspend fun getCryptoList(
//        page: Int, pageSize: Int
//    ): List<Crypto> {
//        val response = CryptolizeApiCall.CRYPTO_SERVICE.getCryptoList(page)
//        return if (response.isSuccessful && !response.body().isNullOrEmpty()) {
//            val body = response.body()
//            val bodyList = mapper.toDomainList(body!!)
//            bodyList
//        } else {
//            emptyList()
//        }
//    }

    private val cryptoDatabase: CryptoDatabase =
        CryptoDatabase.getInstance(context = context)
    private val mapper: MapDTOtoDbEntity = MapDTOtoDbEntity()
    private val cryptoApiCall: CryptolizeApiCall = CryptolizeApiCall

    @OptIn(ExperimentalPagingApi::class)
    @WorkerThread
    override fun getCryptoList(
    ): Flow<PagingData<CryptoEntity>> {

        val pagingSourceFactory = {
            cryptoDatabase.CryptoDao().getAllCrypto()
        }
        return Pager(
            config = PagingConfig(pageSize = 20),
            remoteMediator = CryptoRemoteMediator(
                mapper = mapper,
                cryptoApiCall = cryptoApiCall,
                cryptoDatabase = cryptoDatabase
            ),
            pagingSourceFactory = pagingSourceFactory
        ).flow

    }
}