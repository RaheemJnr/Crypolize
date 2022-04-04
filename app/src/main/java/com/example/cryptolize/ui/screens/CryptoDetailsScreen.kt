package com.example.cryptolize.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.cryptolize.domain.mappers.DetailDTOMapper
import com.example.cryptolize.domain.repository.detail.DetailRepoImpl
import com.example.cryptolize.ui.components.CoinDetailsOverView
import com.example.cryptolize.ui.components.DetailsTopBar
import com.example.cryptolize.ui.components.LineChart
import com.example.cryptolize.ui.theme.gradientGreenColors
import com.example.cryptolize.ui.theme.gradientRedColors
import com.example.cryptolize.ui.viewModels.CoinDetailViewModel
import java.util.*

@Composable
fun DetailScreen(navController: NavHostController, coinId: String, coinName: String) {
    //viewModel
    val viewModel: CoinDetailViewModel = viewModel(
        factory = CoinDetailViewModel.CoinDetailViewModelFactory(DetailRepoImpl(DetailDTOMapper()))
    )

    LaunchedEffect(Unit) {
        viewModel.getCoinDetail(coinId)
    }

    val result = viewModel.getCoin.collectAsState(initial = null).value

    Scaffold(
        topBar = {
            DetailsTopBar(navController, coinName.uppercase(Locale.ROOT))
        }
    ) {
        LazyColumn {
            // coin details overview
            item {
                result?.let { coinDetail -> CoinDetailsOverView(coinDetail = coinDetail) }
            }
            // line chart
            item {
                result?.market_data?.sparkline_7d?.price?.let { it1 ->
                    LineChart(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(350.dp),
                        yAxisValues = it1,
                        lineColors = if (result.market_data.price_change_24h!! > 0) gradientGreenColors else gradientRedColors
                    )
                }
            }
            //
            item {
                Column(
                    Modifier.fillMaxSize()
                ) {
                    //
                    Text(text = "$result")
                }
            }

        }


    }

}