package com.raheemjnr.cryptolize.data.repository.network

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import androidx.room.withTransaction
import com.raheemjnr.cryptolize.data.repository.local.CryptoDatabase
import com.raheemjnr.cryptolize.data.repository.local.entity.CryptoEntity
import com.raheemjnr.cryptolize.data.repository.local.entity.CryptoKeysEntity
import com.raheemjnr.cryptolize.domain.mappers.MapDTOtoDbEntity

@OptIn(ExperimentalPagingApi::class)
class CryptoRemoteMediator(
    private val mapper: MapDTOtoDbEntity,
    private val cryptoApiCall: CryptolizeApiCall,
    private val cryptoDatabase: CryptoDatabase
) : RemoteMediator<Int, CryptoEntity>() {

    private val cryptoDao = cryptoDatabase.CryptoDao()
    private val cryptoKeyDao = cryptoDatabase.CryptoKeysDao()


    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, CryptoEntity>
    ): MediatorResult {
        return try {
            val currentPage = when (loadType) {
                LoadType.REFRESH -> {
                    val remoteKeys =
                        getRemoteKeyClosestToCurrentPosition(state)
                    remoteKeys?.nextPage?.minus(1) ?: 1
                }
                LoadType.PREPEND -> {
                    val remoteKeys = getRemoteKeyForFirstItem(state)
                    val prevPage = remoteKeys?.prevPage
                        ?: return MediatorResult.Success(
                            endOfPaginationReached = remoteKeys != null
                        )
                    prevPage
                }
                LoadType.APPEND -> {
                    val remoteKeys = getRemoteKeysForLastItem(state)
                    val nextPage = remoteKeys?.nextPage
                        ?: return MediatorResult.Success(
                            endOfPaginationReached = remoteKeys != null
                        )
                    nextPage
                }
            }
            val response = cryptoApiCall.CRYPTO_SERVICE.getCryptoList(
                page = currentPage, pageSize = 20
            )
            val endOfPaginationReached = response.isEmpty()

            val prevPage = if (currentPage == 1) null else currentPage - 1
            val nextPage = if (endOfPaginationReached) null else currentPage + 1

            cryptoDatabase.withTransaction {
                if (loadType == LoadType.REFRESH) {
                    cryptoDao.delete()
                    cryptoKeyDao.deleteAllRemoteKeys()
                }
                val keys = response.map { cryptoDto ->
                    CryptoKeysEntity(
                        id = cryptoDto.id!!,
                        prevPage = prevPage,
                        nextPage = nextPage
                    )
                }
                cryptoKeyDao.adAllRemoteKeys(remoteKeys = keys)
                cryptoDao
                    .insertAllCrypto(cryptoEntity = mapper.toDomainList(response))
            }
            MediatorResult.Success(endOfPaginationReached = endOfPaginationReached)
        } catch (e: Exception) {
            return MediatorResult.Error(e)
        }
    }

    private suspend fun getRemoteKeysForLastItem(
        state: PagingState<Int, CryptoEntity>
    ): CryptoKeysEntity? {
        return state.pages.lastOrNull { it.data.isNotEmpty() }?.data?.lastOrNull()
            ?.let { cryptoEntity ->
                cryptoEntity.id.let { cryptoKeyDao.getRemoteKeys(id = it) }
            }
    }

    private suspend fun getRemoteKeyForFirstItem(
        state: PagingState<Int, CryptoEntity>
    ): CryptoKeysEntity? {
        return state.pages.firstOrNull { it.data.isNotEmpty() }?.data?.firstOrNull()
            ?.let { cryptoEntity ->
                cryptoEntity.id.let { cryptoKeyDao.getRemoteKeys(id = it) }
            }


    }

    private suspend fun getRemoteKeyClosestToCurrentPosition(
        state: PagingState<Int, CryptoEntity>
    ): CryptoKeysEntity? {
        return state.anchorPosition?.let { position ->
            state.closestItemToPosition(position)?.id?.let { id ->
                cryptoKeyDao.getRemoteKeys(id = id)
            }

        }

    }
}