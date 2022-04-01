package com.example.cryptolize.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.cryptolize.ui.screens.CryptoListScreen
import com.example.cryptolize.ui.screens.DetailScreen
import com.google.accompanist.pager.ExperimentalPagerApi

/** nav graph to navigate to respective screens */
@ExperimentalPagerApi
@ExperimentalAnimationApi
@ExperimentalMaterialApi
@Composable
fun MainScreenNavigation() {

    val navController = rememberNavController()

    NavHost(navController, startDestination = MainScreen.CryptoListScreen.route) {
        //List
        composable(MainScreen.CryptoListScreen.route) {
            CryptoListScreen(navController = navController)
        }

        composable(MainScreen.DetailScreen.route) {

        }

        //detail screen
        composable("${MainScreen.DetailScreen.route}/{coin}") { backStackEntry ->
            DetailScreen(navController, backStackEntry.arguments?.getString("coin") ?: "")
        }

    }


}