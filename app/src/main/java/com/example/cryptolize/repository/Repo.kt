package com.example.cryptolize.repository

import com.example.cryptolize.domain.models.CryptoListModel

/**
 * interface to get our data
 */
interface CryptolizeRepo {
    suspend fun getGitHubDataList(page: Int, pageSize: Int): List<CryptoListModel>
}