package com.raheemjnr.cryptolize.navigation

sealed class MainScreen(val route: String) {
    object CryptoListScreen : MainScreen("cryptoListScreen")
    object DetailScreen : MainScreen("detailScreen")

}