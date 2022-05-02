package com.example.cryptolize.ui.components

import android.content.Context
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.annotation.ExperimentalCoilApi
import com.example.cryptolize.domain.models.detailModel.CoinDetail
import com.example.cryptolize.utils.Formatter.formatCurrency
import com.example.cryptolize.utils.Formatter.formatWithoutCurrency
import java.util.*

@OptIn(ExperimentalAnimationApi::class, ExperimentalCoilApi::class)
@Composable
fun InfoUI(coinDetail: CoinDetail, context: Context) {
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
            Spacer(modifier = Modifier.width(4.dp))
            Text(
                text = "${coinDetail.symbol?.uppercase(Locale.ROOT)}",
                style = MaterialTheme.typography.h5,
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
            DetailsInfoLeftSIdeItem(text = "Rank")
            DetailsInfoRightSideItem(text = "${coinDetail.market_cap_rank}")
        }
        //market cap
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            DetailsInfoLeftSIdeItem(text = "Market cap")
            DetailsInfoRightSideItem(
                text = formatCurrency(
                    coinDetail.market_data?.market_cap?.usd ?: "--"
                )
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
            DetailsInfoLeftSIdeItem(text = "circulation Supply")
            DetailsInfoRightSideItem(
                text = formatWithoutCurrency(
                    coinDetail.market_data?.circulating_supply ?: "--"
                )
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
            DetailsInfoLeftSIdeItem(text = "Max Supply")
            coinDetail.market_data?.max_supply?.let { formatCurrency(it) }?.let {
                DetailsInfoRightSideItem(
                    text = it
                )
            }
        }
        //total supply
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            DetailsInfoLeftSIdeItem(text = "Total Supply")
            DetailsInfoRightSideItem(
                text = coinDetail.market_data?.total_supply?.let { formatWithoutCurrency(it) }
            )
        }
    }
    //Ath
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        DetailsInfoLeftSIdeItem(text = "ATH")
        DetailsInfoRightSideItem(
            text =
            formatCurrency(coinDetail.market_data?.ath?.usd ?: "--")
        )
    }
    //description
    Column(
        modifier = Modifier
            .padding(8.dp)
    ) {

        DetailsInfoLeftSIdeItem(text = "Description")
        Text(
            text = "${coinDetail.description?.en}",
            style = MaterialTheme.typography.body2,
            textAlign = TextAlign.Start
        )
    }
    //reference link
    ReferenceUI(coinDetail = coinDetail, context = context)
    Spacer(modifier = Modifier.height(30.dp))

}


@Composable
fun DetailsInfoRightSideItem(text: String?) {
    if (text != null) {
        Text(
            text = text,
            style = MaterialTheme.typography.body1,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )
    }
}

@Composable
fun DetailsInfoLeftSIdeItem(text: String) {
    Text(
        text = text,
        fontSize = 18.sp,
        fontWeight = FontWeight.Bold,
        color = Color.Black.copy(alpha = 0.5f)
    )
}

@Preview
@Composable
fun InfoUIPrev() {
    InfoUI(coinDetail = CoinDetail(), LocalContext.current)
}