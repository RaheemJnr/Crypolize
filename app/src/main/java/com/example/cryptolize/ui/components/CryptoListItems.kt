package com.example.cryptolize.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cryptolize.domain.models.Crypto
import com.example.cryptolize.utils.Formatter.formatCurrency
import com.example.cryptolize.utils.Formatter.roundPriceChange
import com.example.cryptolize.utils.Formatter.roundToThreeDecimals
import com.example.cryptolize.utils.Formatter.roundToTwoDecimals
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
                fontSize = 18.sp
            )
        ) {
            append("${items.symbol?.uppercase(Locale.ROOT)} ")
        }
        withStyle(
            style = SpanStyle(
                fontSize = 18.sp,
                fontStyle = FontStyle.Italic,
                fontWeight = FontWeight.Normal,
                color = Color.Black.copy(alpha = 0.5f)
            )
        ) {
            append("/")
        }
        withStyle(
            style = SpanStyle(
                fontWeight = FontWeight.Normal,
                fontSize = 16.sp,
                color = Color.Black.copy(alpha = 0.5f)
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
            .padding(18.dp)
            .clickable {
                onClick()
            }
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
                color = Color.Black.copy(alpha = 0.5f)
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
            )
            Text(
                text = formatCurrency(items.current_price.roundToThreeDecimals().toDouble()),
                fontSize = 14.sp,
                color = Color.Black.copy(alpha = 0.5f)
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
                fontSize = 17.sp,
                modifier = Modifier
                    .width(55.dp)
                    .height(35.dp)
                    .offset(x = (4).dp)
                    .padding(10.dp)
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