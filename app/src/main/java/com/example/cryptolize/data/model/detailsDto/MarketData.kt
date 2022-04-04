package com.example.cryptolize.data.model.detailsDto

import com.squareup.moshi.Json

data class MarketData(
    @Json(name = "current_price")
    val current_price: CurrentPrice? = null,
    @Json(name = "ath")
    val ath: Ath? = null,
    @Json(name = "ath_change_percentage")
    val ath_change_percentage: AthChangePercentage? = null,
    @Json(name = "market_cap")
    val market_cap: MarketCap? = null,
    @Json(name = "market_cap_rank")
    val market_cap_rank: Int? = null,
    @Json(name = "total_volume")
    val total_volume: TotalVolume? = null,
    @Json(name = "high_24h")
    val high_24h: High24h? = null,
    @Json(name = "low_24h")
    val low_24h: Low24h? = null,
    @Json(name = "price_change_24h")
    val price_change_24h: Double? = null,
    @Json(name = "price_change_percentage_24h")
    val price_change_percentage_24h: Double? = null,
    @Json(name = "price_change_24h_in_currency")
    val price_change_24h_in_currency: PriceChange24hInCurrency? = null,
    @Json(name = "sparkline_7d")
    val sparkline_7d: Sparkline7d? = null,
    @Json(name = "total_supply")
    val total_supply: Double? = null,
    @Json(name = "max_supply")
    val max_supply: Double? = null,
    @Json(name = "circulating_supply")
    val circulating_supply: Double? = null,
    @Json(name = "last_updated")
    val last_updated: String? = null
)


data class TotalVolume(
    @Json(name = "usd")
    val usd: Long? = null,
)


data class PriceChange24hInCurrency(
    @Json(name = "usd") val usd: Double? = null,
)

data class Low24h(
    @Json(name = "usd") val usd: Double? = null,
)

data class High24h(
    @Json(name = "usd") val usd: Double? = null,
)

data class CurrentPrice(
    @Json(name = "usd") val usd: Double? = null,
)


data class AthChangePercentage(

    @Json(name = "usd")
    val usd: Double? = null,
)

data class MarketCap(
    @Json(name = "usd")
    val usd: Long? = null,
)

data class Ath(
    @Json(name = "usd")
    val usd: Double? = null,
)

data class Sparkline7d(
    @Json(name = "price") val price: List<Float>? = listOf()
)
