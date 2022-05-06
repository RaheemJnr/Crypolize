package com.raheemjnr.cryptolize.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.google.accompanist.pager.ExperimentalPagerApi
import com.raheemjnr.cryptolize.ui.screens.CryptoListScreen
import com.raheemjnr.cryptolize.ui.screens.DetailScreen
import com.raheemjnr.cryptolize.ui.theme.CryptolizeTheme

/** nav graph to navigate to respective screens */
@ExperimentalPagerApi
@ExperimentalAnimationApi
@ExperimentalMaterialApi
@Composable
fun MainScreenNavigation() {

    val navController = rememberNavController()
    CryptolizeTheme() {
        NavHost(navController, startDestination = MainScreen.CryptoListScreen.route) {

            //List
            composable(MainScreen.CryptoListScreen.route) {
                CryptoListScreen(navController = navController)
            }

            //detail screen
            composable("${MainScreen.DetailScreen.route}/{coinId}/{coinName}",
                arguments = listOf(
                    navArgument("coinId") {
                        type = NavType.StringType
                    }, navArgument("coinName") {
                        type = NavType.StringType
                    }
                )
            ) { backStackEntry ->
                DetailScreen(
                    navController,
                    coinId = backStackEntry.arguments?.getString("coinId") ?: "",
                    coinName = backStackEntry.arguments?.getString("coinName") ?: "",
                )
            }


        }

    }


}