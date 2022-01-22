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
import com.example.cryptolize.domain.models.CryptoListModel
import com.example.cryptolize.utils.roundToThreeDecimals
import java.util.*

@Composable
fun CryptoListItems(
    items: CryptoListModel,
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
            .padding(12.dp)
            .clickable {
                onClick()
            }
    ) {
        Column() {
            Text(
                text = annotatedText
            )
            //
            Text(
                text = "Vol ${items.total_volume}M",
                fontSize = 14.sp,
                color = Color.Black.copy(alpha = 0.5f)
            )

        }
        Column(
            modifier = Modifier.offset(x = (-20).dp)
        ) {
            //
            Text(
                text = items.current_price!!.roundToThreeDecimals(),
                fontSize = 18.sp,
            )
            Text(
                text = "$${items.current_price.roundToThreeDecimals()}",
                fontSize = 14.sp,
                color = Color.Black.copy(alpha = 0.5f)
            )
        }
        //
        Surface(
            color = when {
                items.price_change_percentage_24h!! > 0 -> Color(0xff32a852)
                items.price_change_percentage_24h.equals(0) -> Color.Gray
                else -> {
                    Color.Red
                }
            },
            shape = RoundedCornerShape(4.dp),
            contentColor = Color.White,
            elevation = 8.dp,
        ) {
            Text(
                text = "${items.price_change_percentage_24h}%",
                fontSize = 18.sp,
                modifier = Modifier.padding(10.dp)
            )
        }

    }
}

//
@Preview(showBackground = true)
@Composable
fun CryptoListItemsPreview() {
    CryptoListItems(
        items = CryptoListModel(
            id = "BTC", symbol = "BTC",
            image = "", current_price = 42205.3,
            price_change_percentage_24h = null, total_volume = 22.4
        ),
        onClick = {}
    )


}