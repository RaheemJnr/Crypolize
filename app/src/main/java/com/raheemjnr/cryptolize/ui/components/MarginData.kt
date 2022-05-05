package com.raheemjnr.cryptolize.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.raheemjnr.cryptolize.domain.models.detailModel.CoinDetail
import com.raheemjnr.cryptolize.ui.components.charts.BarCharts
import com.raheemjnr.cryptolize.ui.theme.gradientGreenColors
import com.raheemjnr.cryptolize.ui.theme.gradientRedColors

@Composable
fun MarginData(coinDetail: CoinDetail) {

    Column(
        modifier = Modifier
            .padding(8.dp)
    ) {
        Text(
            text = "Margin Data",
            style = MaterialTheme.typography.h5,
            modifier = Modifier.padding(8.dp)
        )
        Text(
            text = "7 days Charts in Bars",
            style = MaterialTheme.typography.subtitle1,
            modifier = Modifier.padding(8.dp)
        )

        coinDetail.market_data?.sparkline_7d?.price?.let {
            BarCharts(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(350.dp),
                barColors = if (coinDetail.market_data.price_change_24h!! > 0) gradientGreenColors else gradientRedColors,
                barWidth = 2f,
                yAxisValues = it
            )
        }

    }
    Spacer(modifier = Modifier.width(50.dp))
}
