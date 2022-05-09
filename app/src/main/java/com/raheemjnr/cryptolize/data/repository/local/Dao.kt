package com.raheemjnr.cryptolize.data.repository.local

import androidx.room.*

@Dao
interface UserDao {
    ¶
    @Transaction
    @Query("SELECT * FROM local_crypto_table")
    fun getAllCrypto(): List<CryptoEntity>


    @Query(
        """
            SELECT * FROM local_crypto_table
            WHERE LOWER(id)
        """
    )
   suspend fun searchCrypto(first: String, last: String): User

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllCrypto(cryptoEntity: List<CryptoEntity>)


}