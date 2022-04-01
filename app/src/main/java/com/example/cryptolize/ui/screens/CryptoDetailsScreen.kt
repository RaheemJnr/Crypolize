package com.example.cryptolize.ui.screens

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.cryptolize.data.DetailDTOMapper
import com.example.cryptolize.domain.repository.detail.DetailRepoImpl
import com.example.cryptolize.ui.viewModels.CoinDetailViewModel

@Composable
fun DetailScreen(navController: NavHostController, coinId: String) {
    //viewModel
    val viewModel: CoinDetailViewModel = viewModel(
        factory = CoinDetailViewModel.CoinDetailViewModelFactory(DetailRepoImpl(DetailDTOMapper()))
    )


    Scaffold(
        topBar = {}
    ) {
        viewModel.getCoinDetail(coinId = coinId)
    }

}