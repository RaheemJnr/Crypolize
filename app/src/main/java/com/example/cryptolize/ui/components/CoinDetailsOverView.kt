package com.example.cryptolize.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cryptolize.domain.models.detailModel.CoinDetail
import com.example.cryptolize.utils.Formatter.formatCurrency
import com.example.cryptolize.utils.roundToThreeDecimals
import java.util.*

@Composable
fun CoinDetailsOverView(coinDetail: CoinDetail) {

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
                    text = formatCurrency(coinDetail.market_data?.current_price?.usd!!.toDouble()),
                    fontSize = 26.sp,
                )
                Text(
                    text = formatCurrency(coinDetail.market_data.current_price.usd.toDouble()),
                    fontSize = 22.sp,
                    color = Color.Black.copy(alpha = 0.5f)
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
                )
                Text(
                    text = formatCurrency(coinDetail.market_data?.total_volume?.usd!!.toDouble()),
                    fontSize = 12.sp,
                    color = Color.Black.copy(alpha = 0.5f)
                )
                //
                Text(
                    text = "24h% Change",
                    fontSize = 14.sp,
                )
                Text(
                    text = formatCurrency(coinDetail.market_data.price_change_percentage_24h!!.toDouble()),
                    fontSize = 12.sp,
                    color = Color.Black.copy(alpha = 0.5f)
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
                )
                Text(
                    text = formatCurrency(coinDetail.market_data?.high_24h?.usd!!.toDouble()),
                    fontSize = 12.sp,
                    color = Color.Black.copy(alpha = 0.5f)
                )
                //
                Text(
                    text = "24h Low",
                    fontSize = 14.sp,
                )
                Text(
                    text = formatCurrency(coinDetail.market_data.low_24h?.usd!!.toDouble()),
                    fontSize = 12.sp,
                    color = Color.Black.copy(alpha = 0.5f)
                )
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