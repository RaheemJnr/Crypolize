package com.example.cryptolize.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController

/** nav graph to navigate to respective screens */
@ExperimentalAnimationApi
@ExperimentalMaterialApi
@Composable
fun MainScreenNavigation() {

    val navController = rememberNavController()

//    NavHost(navController, startDestination = MainScreen.GitListScreen.route) {
//        //List
//        composable(MainScreen.GitListScreen.route) {
//            GitHubListScreen()
//        }
//        //
////        composable(MainScreen.DetailsList.route) {
////            // WeatherDetailScreen()
////        }
//
//    }


}