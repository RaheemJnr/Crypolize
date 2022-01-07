package com.example.cryptolize.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.cryptolize.R
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.delay

@ExperimentalPagerApi
@Composable
fun ListCarousel() {
    val images = listOf(
        R.drawable.ic_launcher_foreground,
        R.drawable.ic_launcher_background,
        R.drawable.splash_icon,
        // include the other images here...
    )
    val text = listOf(
        "Bitcoin", "eth", "one"
    )

    val pageState = rememberPagerState()
    Row {
        Card(
            elevation = 8.dp,
            shape = RoundedCornerShape(16.dp),
            modifier = Modifier
                .size(width = 390.dp, height = 150.dp)
                .padding(start = 16.dp, end = 16.dp, top = 16.dp)
        ) {
            HorizontalPager(
                state = pageState,
                count = images.size
            ) { page ->
                Image(
                    painterResource(id = images[page]),
                    null,
                    modifier = Modifier.size(100.dp),
                    contentScale = ContentScale.Crop
                )
            }


        }
        LazyRow(
            state = LazyListState(pageState.currentPage)
        ) {
            itemsIndexed(text) { _, item ->
                Text(text = item)
            }

        }
    }
    LaunchedEffect(pageState.currentPage) {
        delay(3000) // wait for 3 seconds.
        // increasing the position and check the limit
        var newPosition = pageState.currentPage + 1
        if (newPosition > images.lastIndex) newPosition = 0
        // scrolling to the new position.
        pageState.animateScrollToPage(newPosition)
    }
}