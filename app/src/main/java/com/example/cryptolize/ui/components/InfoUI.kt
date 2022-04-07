package com.example.cryptolize.ui.components

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.annotation.ExperimentalCoilApi
import com.example.cryptolize.domain.models.detailModel.CoinDetail
import com.example.cryptolize.utils.CoinImage

@OptIn(ExperimentalAnimationApi::class, ExperimentalCoilApi::class)
@Composable
fun InfoUI(coinDetail: CoinDetail) {
    Column(
        modifier = Modifier.padding(8.dp)
    ) {
        //name and image
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            CoinImage(
                uri = coinDetail.image?.thumb,
                contentDescription = " coin image thumb nail"
            )
            Text(
                text = "${coinDetail.symbol}",
                style = MaterialTheme.typography.body1,
                textAlign = TextAlign.Center
            )
        }
        //rank and position
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            Text(
                text = "Rank",
                style = MaterialTheme.typography.body2
            )
            Text(
                text = "${coinDetail.market_cap_rank}",
                style = MaterialTheme.typography.body1,
                textAlign = TextAlign.Center
            )
        }
        //market cap
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            Text(
                text = "Market Cap",
                style = MaterialTheme.typography.body2
            )
            Text(
                text = "${coinDetail.market_data?.market_cap}",
                style = MaterialTheme.typography.body1,
                textAlign = TextAlign.Center
            )
        }
        //circulation supply
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            Text(
                text = "Circulation Supply",
                style = MaterialTheme.typography.body2
            )
            Text(
                text = "${coinDetail.market_data?.circulating_supply}",
                style = MaterialTheme.typography.body1,
                textAlign = TextAlign.Center
            )
        }
        //max supply
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            Text(
                text = "Max Supply",
                style = MaterialTheme.typography.body2
            )
            Text(
                text = "${coinDetail.market_data?.max_supply}",
                style = MaterialTheme.typography.body1,
                textAlign = TextAlign.Center
            )
        }
        //total supply
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            Text(
                text = "Total Supply",
                style = MaterialTheme.typography.body2
            )
            Text(
                text = "${coinDetail.market_data?.total_supply}",
                style = MaterialTheme.typography.body1,
                textAlign = TextAlign.Center
            )
        }
        //Ath
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            Text(
                text = "ATH",
                style = MaterialTheme.typography.body2
            )
            Text(
                text = "${coinDetail.market_data?.ath}",
                style = MaterialTheme.typography.body1,
                textAlign = TextAlign.Center
            )
        }
        //description
        Column(
            modifier = Modifier
                .padding(8.dp)
        ) {
            Text(
                text = "Description",
                style = MaterialTheme.typography.body2
            )
            Text(
                text = "${coinDetail.description}",
                style = MaterialTheme.typography.body2,
                textAlign = TextAlign.Center
            )
        }
        //reference link
        ReferenceUI()
    }

}


@Preview
@Composable
fun InfoUIPrev() {
    InfoUI(coinDetail = CoinDetail())
}