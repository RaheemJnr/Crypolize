package com.raheemjnr.cryptolize.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import com.raheemjnr.cryptolize.R
import kotlinx.coroutines.delay

@ExperimentalPagerApi
@Composable
fun ListCarousel(
    onClick: () -> Unit
) {
    val carouselImages = listOf(
        R.drawable.bitcoin_one,
        R.drawable.bitcoin_two,
        R.drawable.harmony_one,
        R.drawable.nervos_one,
        R.drawable.tezos_one,
        R.drawable.nervous_two,
        R.drawable.harmony_two,
        R.drawable.binance,
    )
    val carouselText = listOf(
        "Bitcoin latest price is now at $100000",
        "Eth is on the verge of surpassing bitcoin's market capitalization",
        "Harmony one is the latest coin to hit the $10 price mark!!",
        "Nervous Network 'CKB' hit the expected $100 price mark!!",
        "Tezos introduced latest Bitcoin Hedge Fund",
        "Nervous successfully link the whole crypto space",
        "Harmony is next best Defi Eco system",
        "Binance still the leading crypto exchange after 30 years!!"
    )

    val pageState = rememberPagerState()
    Row(modifier = Modifier
        .clickable {
            onClick()
        }
    ) {
        Card(
            elevation = 8.dp,
            shape = RoundedCornerShape(16.dp),
            modifier = Modifier
                .size(width = 390.dp, height = 160.dp)
                .padding(start = 16.dp, end = 16.dp, top = 16.dp)
        ) {
            HorizontalPager(
                state = pageState,
                count = carouselImages.size
            ) { page ->
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    //
                    Image(
                        painterResource(id = carouselImages[page]),
                        "",
                        modifier = Modifier
                            .fillMaxHeight(0.87f)
                            .fillMaxWidth(),
                        contentScale = ContentScale.Crop
                    )
                    //
                    Text(
                        text = carouselText[page],
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        fontSize = 16.sp,
                        fontFamily = FontFamily.Serif,
                        modifier = Modifier.padding(start = 8.dp, end = 8.dp, bottom = 10.dp)
                    )
                }
            }


        }
    }
    LaunchedEffect(pageState.currentPage) {
        // wait for 3 seconds.
        delay(3000)
        // increasing the position and check the size
        var newPosition = pageState.currentPage + 1
        if (newPosition > carouselImages.lastIndex) newPosition = 0
        // scrolling to the new position(starting from the beginning).
        pageState.animateScrollToPage(newPosition)
    }
}