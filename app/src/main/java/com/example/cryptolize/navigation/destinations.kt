package com.example.cryptolize.navigation

sealed class MainScreen(val route: String) {
    object CryptoListScreen : MainScreen("cryptoListScreen")
    //object DetailsList : MainScreen("detail")

}