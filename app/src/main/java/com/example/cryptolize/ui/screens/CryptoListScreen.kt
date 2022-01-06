package com.example.cryptolize.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
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
import com.example.cryptolize.ui.viewModels.CryptoListViewModel

@Composable
fun CryptoListScreen() {

    val viewModel: CryptoListViewModel = viewModel(
        factory = CryptoListViewModel.CryptoListViewModelFactory(CryptolizeRepoImpl(DTOMapper()))
    )
    //
    val pagingItems = viewModel.getCryptoList().collectAsLazyPagingItems()
    val lazyListState = rememberLazyListState()




    Surface(
        modifier = Modifier.padding(8.dp)
    ) {

        LazyColumn(state = lazyListState) {
            itemsIndexed(pagingItems) { _, item ->
                if (item != null) {
                    Column() {
                        Text(text = item.toString())

                    }
                }
            }
        }
    }
}