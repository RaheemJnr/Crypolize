package com.example.cryptolize

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.example.cryptolize.navigation.MainScreenNavigation
import com.example.cryptolize.ui.theme.CryptolizeTheme
import com.google.accompanist.pager.ExperimentalPagerApi

class MainActivity : ComponentActivity() {

    @OptIn(
        ExperimentalPagerApi::class, ExperimentalAnimationApi::class,
        ExperimentalMaterialApi::class
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //splash screen
        installSplashScreen()

        setContent {
            CryptolizeTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    MainScreenNavigation()
                }
            }
        }
    }
}


@ExperimentalPagerApi
@ExperimentalMaterialApi
@ExperimentalAnimationApi
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    CryptolizeTheme {
        MainScreenNavigation()
    }
}