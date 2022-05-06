package com.raheemjnr.cryptolize.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.raheemjnr.cryptolize.R

@Composable
fun DetailsTopBar(navController: NavController, coinName: String) {
    Surface(
        color = MaterialTheme.colors.surface
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            Icon(
                imageVector = Icons.Filled.ArrowBack,
                contentDescription = "back arrow",
                tint = MaterialTheme.colors.secondary,
                modifier = Modifier
                    .size(26.dp)
                    .clickable {
                        navController.popBackStack()
                    }
            )
            ConstraintLayout(modifier = Modifier) {

                val (swapIcon, pairText) = createRefs()
                Icon(
                    painterResource(id = R.drawable.pair_swap),
                    contentDescription = "swap pair",
                    tint = MaterialTheme.colors.secondary,
                    modifier = Modifier
                        .size(26.dp)
                        .constrainAs(swapIcon) {
                            top.linkTo(parent.top)
                            bottom.linkTo(parent.bottom)
                            end.linkTo(pairText.start, margin = 2.dp)
                        }
                )
                Text(
                    text = "${coinName}/USDT",
                    style = MaterialTheme.typography.h6,
                    color = MaterialTheme.colors.primary,
                    modifier = Modifier
                        .constrainAs(pairText) {
                            top.linkTo(swapIcon.top)
                            bottom.linkTo(swapIcon.bottom)
                        }
                )
            }
            //favorite
            Icon(
                imageVector = Icons.Filled.Favorite,
                contentDescription = "notification",
                modifier = Modifier
                    .size(26.dp)
                    .padding(end = 8.dp),
                tint = MaterialTheme.colors.secondary
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DetailTopAppbarPrev() {
    DetailsTopBar(navController = rememberNavController(), coinName = "BTC")
}