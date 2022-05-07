package com.raheemjnr.cryptolize.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.raheemjnr.cryptolize.domain.models.Crypto
import com.raheemjnr.cryptolize.utils.Formatter.formatCurrency
import com.raheemjnr.cryptolize.utils.Formatter.roundPriceChange
import com.raheemjnr.cryptolize.utils.Formatter.roundToThreeDecimals
import com.raheemjnr.cryptolize.utils.Formatter.roundToTwoDecimals
import java.util.*

@Composable
fun CryptoListItems(
    items: Crypto,
    onClick: () -> Unit,
) {
    val annotatedText = buildAnnotatedString {
        withStyle(
            style = SpanStyle(
                fontWeight = FontWeight.SemiBold,
                fontSize = 18.sp,
                color = MaterialTheme.colors.primary
            )
        ) {
            append("${items.symbol?.uppercase(Locale.ROOT)} ")
        }
        withStyle(
            style = SpanStyle(
                fontSize = 18.sp,
                fontStyle = FontStyle.Italic,
                fontWeight = FontWeight.Normal,
                color = MaterialTheme.colors.primary
            )
        ) {
            append("/")
        }
        withStyle(
            style = SpanStyle(
                fontWeight = FontWeight.Normal,
                fontSize = 16.sp,
                color = MaterialTheme.colors.primary
            )
        ) {
            append("USDT")
        }

    }

    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                onClick()
            }
            .padding(12.dp)
    ) {
        // name/pair
        Column {
            Text(
                text = annotatedText
            )
            //
            Text(
                text = "Vol ${
                    formatCurrency(
                        items.total_volume.toInt()
                    )
                }",
                fontSize = 14.sp,
                color = MaterialTheme.colors.secondary
            )

        }
        // last price
        Column(
            modifier = Modifier.offset(x = (-20).dp)
        ) {
            //
            Text(
                text = formatCurrency(items.current_price!!.roundToTwoDecimals().toDouble()),
                fontSize = 18.sp,
                color = MaterialTheme.colors.primary
            )
            Text(
                text = formatCurrency(items.current_price.roundToThreeDecimals().toDouble()),
                fontSize = 14.sp,
                color = MaterialTheme.colors.secondary
            )
        }
        // 24h change
        Surface(
            color = when {
                items.price_change_percentage_24h!! > 0 -> Color(0xff32a852)
                items.price_change_percentage_24h.equals(0.0) -> Color.Gray
                else -> {
                    Color.Red
                }
            },
            shape = RoundedCornerShape(4.dp),
            contentColor = Color.White,
            elevation = 8.dp,
        ) {
            Text(
                text = "${items.price_change_percentage_24h.roundPriceChange()}%",
                style = MaterialTheme.typography.subtitle2,
                modifier = Modifier
                    .width(55.dp)
                    .height(35.dp)
                    .padding(10.dp),
                textAlign = TextAlign.Center
            )
        }

    }
}

//
@Preview(showBackground = true)
@Composable
fun CryptoListItemsPreview() {
    CryptoListItems(
        items = Crypto(
            id = "BTC", symbol = "BTC",
            image = "", current_price = 42205.3,
            price_change_percentage_24h = null, total_volume = 22.4
        ),
        onClick = {}
    )


}