package com.example.cryptolize.domain.models.detailModel


data class MarketData(
    val current_price: CurrentPrice,
    val ath: Ath,
    val ath_change_percentage: AthChangePercentage,
    val market_cap: MarketCap,
    val market_cap_rank: Int,
    val total_volume: TotalVolume,
    val high_24h: High24h,
    val low_24h: Low24h,
    val price_change_24h: Double,
    val price_change_percentage_24h: Double,
    val price_change_24h_in_currency: PriceChange24hInCurrency,
    val sparkline_7d: Sparkline7d,
    val total_supply: Double,
    val max_supply: Double,
    val circulating_supply: Double,
    val last_updated: String
)


data class TotalVolume(
    val usd: Long,
)


data class PriceChange24hInCurrency(
    val usd: Double,
)

data class Low24h(
    val usd: Double,

    )

data class High24h(
    val usd: Double,
)

data class CurrentPrice(
    val usd: Double,
)


data class AthChangePercentage(
    val usd: Double,
)

data class MarketCap(
    val usd: Long,
)

data class Ath(
    val usd: Double,
)

data class Sparkline7d(
    val price: List<Double>
)