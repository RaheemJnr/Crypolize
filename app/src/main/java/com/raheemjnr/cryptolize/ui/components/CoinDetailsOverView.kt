package com.raheemjnr.cryptolize.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.raheemjnr.cryptolize.domain.models.detailModel.CoinDetail
import com.raheemjnr.cryptolize.utils.Formatter.formatCurrency
import java.util.*

@Composable
fun CoinDetailsOverView(coinDetail: CoinDetail) {

    Surface() {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            //price
            Box(
                modifier = Modifier,
                contentAlignment = Alignment.Center
            ) {
                Column(
                    modifier = Modifier.padding(8.dp),
                    verticalArrangement = Arrangement.Center
                ) {
                    //
                    Text(
                        text = formatCurrency(coinDetail.market_data?.current_price?.usd ?: "--"),
                        fontSize = 26.sp,
                        color = MaterialTheme.colors.primary
                    )
                    Text(
                        text = formatCurrency(coinDetail.market_data?.current_price?.usd ?: "--"),
                        fontSize = 22.sp,
                        color = MaterialTheme.colors.secondary.copy(alpha = 0.5f)
                    )
                }
            }

            Row {
                //volume and price %
                Column(
                    modifier = Modifier.padding(8.dp)
                ) {
                    //
                    Text(
                        text = "Volume(${
                            coinDetail.symbol?.uppercase(Locale.ROOT).toString()

                        })",
                        fontSize = 14.sp,
                        color = MaterialTheme.colors.primary
                    )
                    Text(
                        text = formatCurrency(coinDetail.market_data?.total_volume?.usd ?: "--"),
                        fontSize = 12.sp,
                        color = MaterialTheme.colors.secondary
                    )
                    //
                    Text(
                        text = "24h% Change",
                        fontSize = 14.sp,
                        color = MaterialTheme.colors.primary
                    )
                    Text(
                        text = "${coinDetail.market_data?.price_change_percentage_24h}",
                        fontSize = 12.sp,
                        color = MaterialTheme.colors.secondary
                    )
                }

                // highs and lows
                Column(
                    modifier = Modifier.padding(8.dp)
                ) {
                    //
                    Text(
                        text = "24h High",
                        fontSize = 14.sp,
                        color = MaterialTheme.colors.primary
                    )
                    Text(
                        text = formatCurrency(coinDetail.market_data?.high_24h?.usd ?: "--"),
                        fontSize = 12.sp,
                        color = MaterialTheme.colors.secondary
                    )
                    //
                    Text(
                        text = "24h Low",
                        fontSize = 14.sp,
                        color = MaterialTheme.colors.primary
                    )
                    Text(
                        text = formatCurrency(coinDetail.market_data?.low_24h?.usd ?: "--"),
                        fontSize = 12.sp,
                        color = MaterialTheme.colors.secondary
                    )
                }
            }
        }
    }
}


@Preview
@Composable
fun CoinDetailsOverViewPrev() {
    CoinDetailsOverView(
        coinDetail = CoinDetail(

        )
    )
}