package com.example.cryptolize.domain.models.detailModel

import com.example.cryptolize.data.model.detailsDto.Description
import com.example.cryptolize.data.model.detailsDto.Image
import com.example.cryptolize.data.model.detailsDto.Links
import com.example.cryptolize.data.model.detailsDto.MarketData


data class CoinDetail(
    val id: String,
    val symbol: String,
    val name: String,
    val description: Description,
    val links: Links,
    val image: Image,
    val market_cap_rank: Int,
    val market_data: MarketData,
)

data class Description(
    val en: String
)

data class Image(
    val thumb: String,
    val small: String,
)

data class Links(
    val homepage: List<String>,
    val twitter_screen_name: String,
    val subreddit_url: String,
    val repos_url: ReposUrl
)

data class ReposUrl(
    val github: List<String>,
    val bitbucket: List<String>
)