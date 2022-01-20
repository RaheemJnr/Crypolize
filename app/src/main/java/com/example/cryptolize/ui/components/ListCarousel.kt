package com.example.cryptolize.ui.components

import androidx.compose.foundation.Image
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
import com.example.cryptolize.R
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.delay

@ExperimentalPagerApi
@Composable
fun ListCarousel() {
    val carouselImages = listOf(
        R.drawable.ic_launcher_foreground,
        R.drawable.ic_launcher_background,
        R.drawable.splash_icon,
    )
    val carouselText = listOf(
        "Bitcoin latest price is now at $100000",
        "Eth is on the verge of surpassing bitcoin's market capitalization",
        "Harmony one is the latest coin to hit the $10 price mark!!"
    )

    val pageState = rememberPagerState()
    Row {
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