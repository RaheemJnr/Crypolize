package com.example.cryptolize.data.model.detailsDto

import com.squareup.moshi.Json

data class MarketData(
    @Json(name = "current_price")
    val current_price: CurrentPrice,
    @Json(name = "ath")
    val ath: Ath,
    @Json(name = "ath_change_percentage")
    val ath_change_percentage: AthChangePercentage,
    @Json(name = "market_cap")
    val market_cap: MarketCap,
    @Json(name = "market_cap_rank")
    val market_cap_rank: Int,
    @Json(name = "total_volume")
    val total_volume: TotalVolume,
    @Json(name = "high_24h")
    val high_24h: High24h,
    @Json(name = "low_24h")
    val low_24h: Low24h,
    @Json(name = "price_change_24h")
    val price_change_24h: Double,
    @Json(name = "price_change_percentage_24h")
    val price_change_percentage_24h: Double,
    @Json(name = "price_change_24h_in_currency")
    val price_change_24h_in_currency: PriceChange24hInCurrency,
    @Json(name = "sparkline_7d")
    val sparkline_7d: Sparkline7d,
    @Json(name = "total_supply")
    val total_supply: Double,
    @Json(name = "max_supply")
    val max_supply: Double,
    @Json(name = "circulating_supply")
    val circulating_supply: Double,
    @Json(name = "last_updated")
    val last_updated: String
)


data class TotalVolume(
    @Json(name = "usd")
    val usd: Int,
)


data class PriceChange24hInCurrency(
    @Json(name = "usd") val usd: Double,
)

data class Low24h(
    @Json(name = "usd") val usd: Double,
)

data class High24h(
    @Json(name = "usd") val usd: Double,
)

data class CurrentPrice(
    @Json(name = "usd") val usd: Double,
)


data class AthChangePercentage(

    @Json(name = "usd")
    val usd: Double,
)

data class MarketCap(
    @Json(name = "usd")
    val usd: Int,
)

data class Ath(
    @Json(name = "usd")
    val usd: Double,
)

data class Sparkline7d(
    @Json(name = "price") val price: List<Double>
)
