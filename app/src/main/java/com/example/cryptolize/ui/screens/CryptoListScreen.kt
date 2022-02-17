package com.example.cryptolize.ui.screens

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.itemsIndexed
import com.example.cryptolize.data.DTOMapper
import com.example.cryptolize.domain.repository.CryptolizeRepoImpl
import com.example.cryptolize.ui.components.CryptoListItems
import com.example.cryptolize.ui.components.ListCarousel
import com.example.cryptolize.ui.components.ListHeader
import com.example.cryptolize.ui.components.ListTopAppbar
import com.example.cryptolize.ui.viewModels.CryptoListViewModel
import com.example.cryptolize.utils.showShortToast
import com.google.accompanist.pager.ExperimentalPagerApi

@ExperimentalPagerApi
@Composable
fun CryptoListScreen() {
    //viewModel
    val viewModel: CryptoListViewModel = viewModel(
        factory = CryptoListViewModel.CryptoListViewModelFactory(CryptolizeRepoImpl(DTOMapper()))
    )
    //
    val context = LocalContext.current
    //
    val pagingItems = viewModel.getCryptoList().collectAsLazyPagingItems()
    val lazyListState = rememberLazyListState()

    Scaffold(
        topBar = {
            ListTopAppbar()
        }
    ) {
        Column {
            ListCarousel()
            Spacer(modifier = Modifier.height(10.dp))
            // list header
            ListHeader()
            //
            Surface {
                //
                LazyColumn(state = lazyListState) {
                    itemsIndexed(pagingItems) { _, item ->
                        item?.let {
                            Column {
                                CryptoListItems(
                                    items = item,
                                    onClick = {
                                        showShortToast(
                                            context = context,
                                            message = "clicked ${item.symbol}"
                                        )
                                    }
                                )
                            }
                        }
                    }
                    pagingItems.apply {
                        when {
                            loadState.refresh is LoadState.Loading -> item {
                                CircularProgressIndicator()
                            }
                            loadState.append is LoadState.Loading -> item {
                                CircularProgressIndicator()
                            }
                            loadState.refresh is LoadState.Error -> item {
                                //refactor
                                Text(text = "Error fetching data")
                            }
                        }
                    }
                }
            }
        }
    }
}


