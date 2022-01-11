package com.example.cryptolize.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.itemsIndexed
import com.example.cryptolize.data.DTOMapper
import com.example.cryptolize.repository.CryptolizeRepoImpl
import com.example.cryptolize.ui.components.ListCarousel
import com.example.cryptolize.ui.components.ListTopAppbar
import com.example.cryptolize.ui.viewModels.CryptoListViewModel
import com.google.accompanist.pager.ExperimentalPagerApi

@ExperimentalPagerApi
@Composable
fun CryptoListScreen() {

    val viewModel: CryptoListViewModel = viewModel(
        factory = CryptoListViewModel.CryptoListViewModelFactory(CryptolizeRepoImpl(DTOMapper()))
    )
    //
    val pagingItems = viewModel.getCryptoList().collectAsLazyPagingItems()
    val lazyListState = rememberLazyListState()

    Scaffold(
        topBar = {
            ListTopAppbar()
        }
    ) {
        Column(
        ) {
            ListCarousel()
            //
            Surface(
                modifier = Modifier.padding(8.dp)
            ) {
//                LazyColumn(state = lazyListState) {
//                    itemsIndexed(pagingItems) { _, item ->
//                        if (item != null) {
//                            Column() {
//                                Text(text = item.toString())
//
//                            }
//                        }
//                    }
//                }
            }
        }
    }

}