package com.raheemjnr.cryptolize.domain.repository.list

import com.raheemjnr.cryptolize.domain.models.Crypto


/**
 * interface to get our data
 */
interface ListRepo {
    //list
    suspend fun getCryptoList(page: Int, pageSize: Int): List<Crypto>

}