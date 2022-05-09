package com.raheemjnr.cryptolize.data.repository.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [CryptoEntity::class], version = 1)
abstract class CryptoDatabase() : RoomDatabase() {

    //dao
    abstract fun dao() : CryptoDao

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