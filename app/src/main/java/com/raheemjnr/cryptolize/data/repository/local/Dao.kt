package com.raheemjnr.cryptolize.data.repository.local

import androidx.room.*

@Dao
interface CryptoDao {

    @Transaction
    @Query("SELECT * FROM local_crypto_table")
    suspend fun getAllCrypto(): List<CryptoEntity>

    @Query(
        """
            SELECT * FROM local_crypto_table
            WHERE LOWER(id) LIKE '%' || LOWER(:query) || '%' OR
            UPPER(:query) == symbol
        """
    )
    suspend fun searchCrypto(query: String): List<CryptoEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllCrypto(cryptoEntity: List<CryptoEntity>)

    @Query("SELECT * FROM local_crypto_table")
    suspend fun delete()


}