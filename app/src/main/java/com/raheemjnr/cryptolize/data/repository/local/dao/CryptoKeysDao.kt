package com.raheemjnr.cryptolize.data.repository.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.raheemjnr.cryptolize.data.repository.local.entity.CryptoKeysEntity

@Dao
interface CryptoKeysDao {

    @Query(value = "SELECT * FROM Crypto_keys_table WHERE id = :id")
    suspend fun getRemoteKeys(id: String): CryptoKeysEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun adAllRemoteKeys(remoteKeys: List<CryptoKeysEntity>)

    @Query(value = "DELETE FROM Crypto_keys_table")
    suspend fun deleteAllRemoteKeys()

}