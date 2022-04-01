package com.example.cryptolize.data.model.detailsDto

import com.squareup.moshi.Json

data class DetailsDTO(

    @Json(name = "id")
    val id: String,
    @Json(name = "symbol")
    val symbol: String,
    @Json(name = "name")
    val name: String,
    @Json(name = "description")
    val description: Description,
    @Json(name = "links")
    val links: Links,
    @Json(name = "image")
    val image: Image,
    @Json(name = "market_cap_rank")
    val market_cap_rank: Int,
    @Json(name = "market_data")
    val market_data: MarketData,
)

data class Description(
    @Json(name = "en") val en: String
)

data class Image(
    @Json(name = "thumb") val thumb: String,
    @Json(name = "small") val small: String,
)

data class Links(
    @Json(name = "homepage") val homepage: List<String>,
    @Json(name = "twitter_screen_name") val twitter_screen_name: String,
    @Json(name = "subreddit_url") val subreddit_url: String,
    @Json(name = "repos_url") val repos_url: ReposUrl
)

data class ReposUrl(
    @Json(name = "github") val github: List<String>,
    @Json(name = "bitbucket") val bitbucket: List<String>
)