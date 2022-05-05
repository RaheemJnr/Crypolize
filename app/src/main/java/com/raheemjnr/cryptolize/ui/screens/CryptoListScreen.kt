package com.raheemjnr.cryptolize.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.cryptolize.R
import com.example.cryptolize.domain.mappers.ListDTOMapper
import com.example.cryptolize.domain.repository.list.ListRepoImpl
import com.example.cryptolize.navigation.MainScreen
import com.example.cryptolize.ui.components.CryptoListItems
import com.example.cryptolize.ui.components.ListCarousel
import com.example.cryptolize.ui.components.ListHeader
import com.example.cryptolize.ui.components.ListTopAppbar
import com.example.cryptolize.ui.theme.CryptolizeTheme
import com.example.cryptolize.ui.viewModels.CryptoListViewModel
import com.example.cryptolize.utils.LottieAnimation
import com.example.cryptolize.utils.openUrl
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState

@ExperimentalPagerApi
@Composable
fun CryptoListScreen(navController: NavController) {
    //viewModel
    val viewModel: CryptoListViewModel = viewModel(
        factory = CryptoListViewModel.CryptoListViewModelFactory(ListRepoImpl(ListDTOMapper()))
    )
    //
    val context = LocalContext.current
    //
    val isRefreshing = viewModel.isRefreshing.collectAsState()
    val pagingItems = viewModel.getCryptoList().collectAsLazyPagingItems()
    val lazyListState = rememberLazyListState()

    CryptolizeTheme() {
        Scaffold(
            topBar = {
                ListTopAppbar()
            }
        ) {
            Column {
                ListCarousel(
                    onClick = {
                        context.openUrl(url = "https://github.com/RaheemJnr")
                    }
                )
                Spacer(modifier = Modifier.height(10.dp))
                // list header
                ListHeader()
                //
                Surface {
                    //
                    SwipeRefresh(
                        state = rememberSwipeRefreshState(isRefreshing = isRefreshing.value),
                        onRefresh = {
                            viewModel.refresh()
                        }
                    ) {
                        LazyColumn(state = lazyListState) {
                            items(items = pagingItems,
                                key = { crypto ->
                                    crypto.id.toString()
                                }
                            ) { item ->
                                item?.let {
                                    Column {
                                        CryptoListItems(
                                            items = item,
                                            onClick = {
                                                navController.navigate(
                                                    route =
                                                    "${MainScreen.DetailScreen.route}/${item.id}/${item.symbol}"
                                                )
                                            }
                                        )
                                    }
                                }
                            }
                            pagingItems.apply {
                                when {
                                    //refresh list
                                    loadState.refresh is LoadState.Loading -> item {
                                        Dialog(
                                            onDismissRequest = {},
                                            DialogProperties(
                                                dismissOnBackPress = false,
                                                dismissOnClickOutside = false
                                            )
                                        ) {
                                            Box(
                                                modifier = Modifier
                                                    .size(55.dp)
                                                    .background(
                                                        Color.Transparent,
                                                        shape = RoundedCornerShape(8.dp)
                                                    )
                                            ) {
                                                val composition by rememberLottieComposition(
                                                    LottieCompositionSpec
                                                        // here `code` is the file name of lottie file
                                                        // use it accordingly
                                                        .RawRes(R.raw.cryptolize_loading_anim)
                                                )
                                                composition?.let { lottieComposition ->
                                                    LottieAnimation(
                                                        showMessage = false,
                                                        composition = lottieComposition
                                                    )
                                                }
                                            }
                                        }
                                    }
                                    //add to the already available list
                                    loadState.append is LoadState.Loading -> item {
                                        val composition by rememberLottieComposition(

                                            LottieCompositionSpec
                                                // here `code` is the file name of lottie file
                                                // use it accordingly
                                                .RawRes(R.raw.cryptolize_loading_anim)
                                        )
                                        composition?.let { lottieComposition ->
                                            LottieAnimation(
                                                showMessage = true,
                                                message = "Loading",
                                                composition = lottieComposition
                                            )
                                        }
                                    }
                                    loadState.refresh is LoadState.Error -> item {
                                        Box(
                                            modifier = Modifier.fillMaxSize(),
                                            contentAlignment = Alignment.BottomCenter,

                                            ) {
                                            val composition by rememberLottieComposition(
                                                LottieCompositionSpec
                                                    .RawRes(R.raw.cryptolize_error)
                                            )
                                            composition?.let { lottieComposition ->
                                                LottieAnimation(
                                                    showMessage = true,
                                                    message = "Some Error Occur",
                                                    composition = lottieComposition
                                                )
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }

                }
            }
        }
    }

}

