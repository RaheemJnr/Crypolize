package com.example.cryptolize.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.cryptolize.domain.mappers.DetailDTOMapper
import com.example.cryptolize.domain.repository.detail.DetailRepoImpl
import com.example.cryptolize.ui.components.CoinDetailsOverView
import com.example.cryptolize.ui.components.DetailsTopBar
import com.example.cryptolize.ui.viewModels.CoinDetailViewModel
import java.util.*

@Composable
fun DetailScreen(navController: NavHostController, coinId: String, coinName: String) {
    //viewModel
    val viewModel: CoinDetailViewModel = viewModel(
        factory = CoinDetailViewModel.CoinDetailViewModelFactory(DetailRepoImpl(DetailDTOMapper()))
    )

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
            //
            item {
                Column(
                    Modifier.fillMaxSize()
                ) {
                    Button(
                        onClick = {
                            viewModel.getCoinDetail(coinId)
                        }
                    ) {
                        Text(text = "Click here")
                    }
                    //
                    Text(text = "$result")
                }
            }

        }


    }

}