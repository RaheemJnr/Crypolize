package com.raheemjnr.cryptolize.domain.repository.list

import androidx.paging.PagingData
import com.raheemjnr.cryptolize.data.repository.local.entity.CryptoEntity
import kotlinx.coroutines.flow.Flow


/**
 * interface to get our data
 */
interface ListRepo {
    //list
     fun getCryptoList(): Flow<PagingData<CryptoEntity>>

     fun searchCrypto(query:String):Flow<PagingData<CryptoEntity>>

}
