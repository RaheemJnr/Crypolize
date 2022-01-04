package com.example.cryptolize.data.network

import com.example.cryptolize.domain.models.CryptoListModel
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

const val BASE_URL = "coins/markets?"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

/**
 * Main entry point for network access.
 */
object GitFindApiCall {
    // Configure retrofit to parse JSON and use coroutines
    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .build()

    //
    val CRYPTO_LIST_SERVICE: CryptoListService by lazy {
        retrofit.create(CryptoListService::class.java)
    }

}

/**
 * A retrofit service to fetch list of github repo data
 * for listScreen
 */
interface CryptoListService {
    //list
    @GET("vs_currency=usd&order=market_cap_desc&sparkline=true")
    suspend fun getAllCrypto(
        @Query("page") page: Int = 1,
        @Query("per_page") pageSize: Int = 2
    ): Response<List<CryptoListModel>>
    // details

}