package com.example.cryptolize.ui.screens

import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController

@Composable
fun DetailScreen(navController: NavHostController, coinId: String) {
    Scaffold(
        topBar = {}
    ) {
        Text(text = coinId)
    }

}