package com.example.cryptolize.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
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
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.cryptolize.R
import com.example.cryptolize.domain.models.detailModel.CoinDetail

@Composable
fun DetailsTopBar(navController: NavController, coinDetail: CoinDetail) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Icon(
            imageVector = Icons.Filled.ArrowBack,
            contentDescription = "back arrow",
            tint = Color.Black,
            modifier = Modifier
                .size(24.dp)
                .clickable {
                    navController.popBackStack()
                }
        )
        Row {
            Icon(
                painterResource(id = R.drawable.pair_swap),
                contentDescription = "swap pair",
                tint = Color.Black,
                modifier = Modifier
                    .size(22.dp)
            )
            Text(
                text = "${coinDetail.name}/USDT",
                modifier = Modifier
            )
        }
        //favorite
        Icon(
            imageVector = Icons.Filled.Favorite,
            contentDescription = "notification",
            modifier = Modifier
                .size(24.dp)

        )
    }
}


@Preview(showBackground = true)
@Composable
fun DetailTopAppbarPrev() {
    DetailsTopBar(navController = rememberNavController(), coinDetail = CoinDetail())
}