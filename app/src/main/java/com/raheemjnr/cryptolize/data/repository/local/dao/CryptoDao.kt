package com.raheemjnr.cryptolize.data.repository.local.dao

import androidx.paging.PagingSource
import androidx.room.*
import com.raheemjnr.cryptolize.data.repository.local.entity.CryptoEntity

@Dao
interface CryptoDao {

    @Transaction
    @Query("SELECT * FROM local_crypto_table")
    fun getAllCrypto(): PagingSource<Int, CryptoEntity>

    @Query(
        """
            SELECT * FROM local_crypto_table
            WHERE LOWER(id) LIKE '%' || LOWER(:query) || '%' OR
            UPPER(:query) == symbol
        """
    )
    fun searchCrypto(query: String): PagingSource<Int, CryptoEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllCrypto(cryptoEntity: List<CryptoEntity>)

    @Query("DELETE FROM local_crypto_table")
    suspend fun delete()


}