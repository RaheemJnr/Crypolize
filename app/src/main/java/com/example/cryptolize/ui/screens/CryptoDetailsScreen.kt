package com.example.cryptolize.ui.screens

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Scaffold
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.cryptolize.R
import com.example.cryptolize.domain.mappers.DetailDTOMapper
import com.example.cryptolize.domain.repository.detail.DetailRepoImpl
import com.example.cryptolize.ui.components.CoinDetailsOverView
import com.example.cryptolize.ui.components.DetailsTopBar
import com.example.cryptolize.ui.components.InfoUI
import com.example.cryptolize.ui.components.MarginData
import com.example.cryptolize.ui.components.charts.LineChart
import com.example.cryptolize.ui.theme.gradientGreenColors
import com.example.cryptolize.ui.theme.gradientRedColors
import com.example.cryptolize.ui.viewModels.CoinDetailViewModel
import com.example.cryptolize.utils.LottieAnimation
import com.example.cryptolize.utils.UIDataState
import com.example.cryptolize.utils.showShortToast
import java.util.*

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun DetailScreen(navController: NavHostController, coinId: String, coinName: String) {
    //viewModel
    val viewModel: CoinDetailViewModel = viewModel(
        factory = CoinDetailViewModel.CoinDetailViewModelFactory(DetailRepoImpl(DetailDTOMapper()))
    )

    val context = LocalContext.current
    LaunchedEffect(Unit) {
        viewModel.getCoinDetail(coinId)
    }

    val resultWithReload = viewModel.getCoinWithReloadData.collectAsState(initial = null).value
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
                val composition by rememberLottieComposition(
                    LottieCompositionSpec
                        // here `code` is the file name of lottie file
                        // use it accordingly
                        .RawRes(R.raw.cryptolize_loading_anim)
                )
                when (resultWithReload) {
                    is UIDataState.Loading -> LottieAnimation(
                        showMessage = false,
                        composition = composition!!
                    )
                    is UIDataState.Success -> {
                        resultWithReload.data.market_data?.sparkline_7d?.price?.let { it1 ->
                            LineChart(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(350.dp),
                                yAxisValues = it1,
                                lineColors = if (resultWithReload.data.market_data.price_change_24h!! > 0) gradientGreenColors else gradientRedColors
                            )
                        }
                    }
                    is UIDataState.Failed -> showShortToast(
                        context,
                        "Failed:${resultWithReload.message}",
                    )
                    else -> {}
                }

            }
            //
            item {
                val titles = listOf("Info", "Margin Data")
                var tabIndex by remember { mutableStateOf(0) }
                Column {
                    TabRow(
                        selectedTabIndex = tabIndex,
                        backgroundColor = Color(0xFFf2f2f6),
                        contentColor = Color.Black,
                        modifier = Modifier
                    ) {
                        titles.forEachIndexed { index, title ->
                            Tab(
                                selected = tabIndex == index,
                                onClick = { tabIndex = index },
                                text = { Text(text = title) }
                            )
                        }
                    }
                    when (tabIndex) {
                        0 -> {
                            result?.let { coinDetail -> InfoUI(coinDetail) }
                        }
                        1 -> {
                            result?.let { coinDetail -> MarginData(coinDetail) }
                        }
                    }
                }

            }
        }
    }

}