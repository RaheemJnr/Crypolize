package com.raheemjnr.cryptolize.data.repository.network

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.raheemjnr.cryptolize.data.model.CryptoListDTO
import com.raheemjnr.cryptolize.data.model.detailsDto.DetailsDTO
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

const val BASE_URL = "https://api.coingecko.com/api/v3/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

/**
 * Main entry point for network access.
 */
object CryptolizeApiCall {
    // Configure retrofit to parse JSON and use coroutines
    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .build()

    //
    val CRYPTO_SERVICE: CryptoService by lazy {
        retrofit.create(CryptoService::class.java)
    }
    //


}

/**
 * A retrofit service to fetch list of github repo data
 * for listScreen
 */
interface CryptoService {
    //list
    @GET("coins/markets?vs_currency=usd&order=market_cap_desc&sparkline=true")
    suspend fun getCryptoList(
        @Query("page") page: Int = 1,
        @Query("per_page") pageSize: Int = 20
    ): Response<List<CryptoListDTO>>

    // details

    @GET(value = "coins/{coinId}?localization=false&tickers=false&market_data=true&community_data=false&developer_data=false&sparkline=true")
    suspend fun getCoinDetails(
        @Path("coinId") coinId: String,
    ): Response<DetailsDTO>

}