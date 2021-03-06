package com.raheemjnr.cryptolize.ui.screens

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.rememberLottieComposition
import com.raheemjnr.cryptolize.R
import com.raheemjnr.cryptolize.domain.mappers.DetailDTOMapper
import com.raheemjnr.cryptolize.domain.repository.detail.DetailRepoImpl
import com.raheemjnr.cryptolize.ui.components.CoinDetailsOverView
import com.raheemjnr.cryptolize.ui.components.DetailsTopBar
import com.raheemjnr.cryptolize.ui.components.InfoUI
import com.raheemjnr.cryptolize.ui.components.MarginData
import com.raheemjnr.cryptolize.ui.components.charts.LineChart
import com.raheemjnr.cryptolize.ui.theme.gradientGreenColors
import com.raheemjnr.cryptolize.ui.theme.gradientRedColors
import com.raheemjnr.cryptolize.ui.viewModels.CoinDetailViewModel
import com.raheemjnr.cryptolize.utils.LottieAnimation
import com.raheemjnr.cryptolize.utils.UIDataState
import com.raheemjnr.cryptolize.utils.showShortToast
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
                        backgroundColor = MaterialTheme.colors.secondary,
                        contentColor = MaterialTheme.colors.primary,
                        modifier = Modifier
                    ) {
                        titles.forEachIndexed { index, title ->
                            Tab(
                                selected = tabIndex == index,
                                onClick = { tabIndex = index },
                                text = {
                                    Text(
                                        text = title,
                                        style = MaterialTheme.typography.h6
                                    )
                                }
                            )
                        }
                    }
                    when (tabIndex) {
                        0 -> {
                            result?.let { coinDetail -> InfoUI(coinDetail, context = context) }
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