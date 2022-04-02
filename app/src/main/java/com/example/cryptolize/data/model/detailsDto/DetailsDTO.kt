package com.example.cryptolize.data.model.detailsDto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class DetailsDTO(

    @Json(name = "id")
    val id: String? = null,
    @Json(name = "symbol")
    val symbol: String? = null,
    @Json(name = "name")
    val name: String? = null,
    @Json(name = "description")
    val description: Description? = null,
    @Json(name = "links")
    val links: Links? = null,
    @Json(name = "image")
    val image: Image? = null,
    @Json(name = "market_cap_rank")
    val market_cap_rank: Int? = null,
    @Json(name = "market_data")
    val market_data: MarketData? = null,
)

data class Description(
    @Json(name = "en") val en: String? = null
)

data class Image(
    @Json(name = "thumb") val thumb: String? = null,
    @Json(name = "small") val small: String? = null,
)

data class Links(
    @Json(name = "homepage") val homepage: List<String>? = listOf(),
    @Json(name = "twitter_screen_name") val twitter_screen_name: String? = null,
    @Json(name = "subreddit_url") val subreddit_url: String? = null,
    @Json(name = "repos_url") val repos_url: ReposUrl? = null
)

data class ReposUrl(
    @Json(name = "github") val github: List<String>? = listOf(),
    @Json(name = "bitbucket") val bitbucket: List<String>? = listOf()
)