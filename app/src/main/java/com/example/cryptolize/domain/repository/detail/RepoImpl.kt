package com.example.cryptolize.domain.repository.detail

import androidx.annotation.WorkerThread
import com.example.cryptolize.domain.mappers.DetailDTOMapper
import com.example.cryptolize.data.network.CryptolizeApiCall
import com.example.cryptolize.domain.models.detailModel.CoinDetail
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Response

class DetailRepoImpl(private val mapper: DetailDTOMapper) : DetailRepo {
    @WorkerThread
    override suspend fun getCoinDetails(coinId: String): CoinDetail? {
        val response =
            CryptolizeApiCall.CRYPTO_SERVICE.getCoinDetails(coinId = coinId)

        return if (response.isSuccessful) {
            val body = response.body()
            val bo = body?.let { mapper.mapToDomainModel(it) }
            bo
        } else {
            null
        }
    }
}


/**
 * Retrofit only gives generic response body when status is Successful.
 * This extension will also parse error body and will give generic response.
 */
inline fun <reified T> Response<T>.getResponse(): T {
    val responseBody = body()
    return if (this.isSuccessful && responseBody != null) {
        responseBody
    } else {
        fromJson<T>(errorBody()!!.string())!!
    }
}

val moshi: Moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()

inline fun <reified T> fromJson(json: String) = moshi.adapter(T::class.java).fromJson(json)

inline val <reified T> T.json get() = moshi.adapter(T::class.java).toJson(this)