package com.example.cryptolize.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.cryptolize.ui.screens.CryptoListScreen

/** nav graph to navigate to respective screens */
@ExperimentalAnimationApi
@ExperimentalMaterialApi
@Composable
fun MainScreenNavigation() {

    val navController = rememberNavController()

    NavHost(navController, startDestination = MainScreen.CryptoListScreen.route) {
        //List
        composable(MainScreen.CryptoListScreen.route) {
            CryptoListScreen()
        }
        //
//        composable(MainScreen.DetailsList.route) {
//
//        }

    }


}