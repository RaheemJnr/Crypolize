package com.raheemjnr.cryptolize.ui.components

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.paging.LoadState
import com.raheemjnr.cryptolize.data.repository.local.entity.CryptoEntity
import com.raheemjnr.cryptolize.domain.models.Crypto
import com.raheemjnr.cryptolize.utils.Formatter.formatCurrency
import com.raheemjnr.cryptolize.utils.Formatter.roundPriceChange
import com.raheemjnr.cryptolize.utils.Formatter.roundToThreeDecimals
import com.raheemjnr.cryptolize.utils.Formatter.roundToTwoDecimals
import com.raheemjnr.cryptolize.utils.SkeletonShimmerAnimation
import java.util.*

@Composable
fun CryptoListItems(
    items: CryptoEntity?,
    onClick: () -> Unit,
) {
    val animatedProgress = remember { Animatable(initialValue = 0.8f) }
    LaunchedEffect(Unit) {
        animatedProgress.animateTo(
            targetValue = 1f,
            animationSpec = tween(300, easing = LinearEasing)
        )
    }
    val annotatedText = buildAnnotatedString {
        withStyle(
            style = SpanStyle(
                fontWeight = FontWeight.SemiBold,
                fontSize = 18.sp,
                color = MaterialTheme.colors.primary
            )
        ) {
            append("${items?.symbol?.uppercase(Locale.ROOT)} ")
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
         .graphicsLayer(scaleY = animatedProgress.value, scaleX = animatedProgress.value)
    ) {
        // name/pair
        Column {
//            SkeletonShimmerAnimation(
//                isLoading = loadState,
//                shape = RectangleShape,
//                contentAlignment = Alignment.Center,
//                contentView = {
//
//                }
//            )
            Text(
                text = annotatedText
            )

            //
            Text(
                text = "Vol ${
                    items?.total_volume?.let {
                        formatCurrency(
                            it.toInt()
                        )
                    }
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
                text = formatCurrency(items?.current_price!!.roundToTwoDecimals().toDouble()),
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
                items?.price_change_percentage_24h!! > 0 -> Color(0xff32a852)
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
