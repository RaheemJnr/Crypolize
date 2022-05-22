package com.raheemjnr.cryptolize.data.repository.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.raheemjnr.cryptolize.data.repository.local.dao.CryptoDao
import com.raheemjnr.cryptolize.data.repository.local.dao.CryptoKeysDao
import com.raheemjnr.cryptolize.data.repository.local.entity.CryptoEntity

@Database(entities = [CryptoEntity::class], version = 1)
abstract class CryptoDatabase() : RoomDatabase() {

    //dao
    abstract fun CryptoDao(): CryptoDao
    abstract fun CryptoKeysDao(): CryptoKeysDao

    companion object {
        private var instance: CryptoDatabase? = null
        private val LOCK = Any()

        fun getInstance(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: buildDatabase(context.applicationContext).also { instance = it }
        }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                CryptoDatabase::class.java, "crypto.db"
            ).build()
    }
}