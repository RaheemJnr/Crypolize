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
import com.raheemjnr.cryptolize.utils.PageNumSource
import kotlinx.coroutines.flow.Flow


class ListRepoImpl(
    context: Context
) : ListRepo {

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
    //    fun getCryptoList(pageSize: Int = 20) =
//        Pager(config = PagingConfig(pageSize = pageSize, initialLoadSize = pageSize)) {
//            PageNumSource { pageNum, pageSize ->
//                repo(pageNum, pageSize)
//            }
//        }.flow.cachedIn(viewModelScope)

    override fun searchCrypto(query: String): Flow<PagingData<CryptoEntity>> {
        return Pager(
            config = PagingConfig(pageSize = 10),
            pagingSourceFactory = {
                PageNumSource(cryptoDatabase = cryptoDatabase, query = query)
            }
        ).flow
    }
}