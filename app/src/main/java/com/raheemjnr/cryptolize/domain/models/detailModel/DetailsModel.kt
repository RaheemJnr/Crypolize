package com.raheemjnr.cryptolize.domain.models.detailModel

import com.example.cryptolize.data.model.detailsDto.Description
import com.example.cryptolize.data.model.detailsDto.Image
import com.example.cryptolize.data.model.detailsDto.Links
import com.example.cryptolize.data.model.detailsDto.MarketData


data class CoinDetail(
    val id: String? = null,
    val symbol: String? = null,
    val name: String? = null,
    val description: Description? = null,
    val links: Links? = null,
    val image: Image? = null,
    val market_cap_rank: Int? = null,
    val market_data: MarketData? = null,
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