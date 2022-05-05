package com.example.cryptolize.domain.repository

import com.example.cryptolize.domain.models.Crypto

/**
 * interface to get our data
 */
interface ListRepo {
    //list
    suspend fun getCryptoList(page: Int, pageSize: Int): List<Crypto>

}