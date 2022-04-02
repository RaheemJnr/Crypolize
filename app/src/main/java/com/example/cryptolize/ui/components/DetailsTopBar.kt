package com.example.cryptolize.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cryptolize.R

@Composable
fun DetailsTopBar() {
//    ConstraintLayout(
//        modifier = Modifier
//            .fillMaxWidth(),
//    ) {
//        val (backButton, swapIcon, pairText, favorite) = createRefs()
//        //person icon
//        Icon(
//            imageVector = Icons.Filled.ArrowBack,
//            contentDescription = "back arrow",
//            tint = Color.Black,
//            modifier = Modifier
//                .size(32.dp)
//                .constrainAs(backButton) {
//                    start.linkTo(parent.start, margin = 8.dp)
//                    top.linkTo(parent.top, margin = 8.dp)
//                    bottom.linkTo(parent.bottom)
//                   // end.linkTo(swapIcon.start, margin = 24.dp)
//                }
//        )
//        Icon(
//            painterResource(id = R.drawable.pair_swap),
//            contentDescription = "swap pair",
//            tint = Color.Black,
//            modifier = Modifier.constrainAs(swapIcon) {
//                start.linkTo(backButton.end)
//                end.linkTo(pairText.start, margin = 4.dp)
//
//            }
//        )
//        Text(
//            "ONE/Usdt",
//            modifier = Modifier.constrainAs(pairText) {
//                end.linkTo(favorite.start)
//                top.linkTo(parent.top, margin = 4.dp)
//                bottom.linkTo(parent.bottom, margin = 4.dp)
//            }
//        )
//        //favorite
//        Icon(
//            imageVector = Icons.Filled.Favorite,
//            contentDescription = "notification",
//            modifier = Modifier
//                .size(28.dp)
//                .constrainAs(favorite) {
//                    end.linkTo(parent.end, margin = 8.dp)
//                    top.linkTo(parent.top)
//                    bottom.linkTo(parent.bottom)
//                }
//        )
//
//
//    }

    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.fillMaxWidth()
    ) {
        Icon(
            imageVector = Icons.Filled.ArrowBack,
            contentDescription = "back arrow",
            tint = Color.Black,
            modifier = Modifier
                .size(32.dp)
        )
        Row {
            Icon(
                painterResource(id = R.drawable.pair_swap),
                contentDescription = "swap pair",
                tint = Color.Black,
                modifier = Modifier
            )
            Text(
                "ONE/Usdt",
                modifier = Modifier

            )
        }
        //favorite
        Icon(
            imageVector = Icons.Filled.Favorite,
            contentDescription = "notification",
            modifier = Modifier
                .size(28.dp)

        )
    }
}


@Preview(showBackground = true)
@Composable
fun DetailTopAppbarPrev() {
    DetailsTopBar()
}