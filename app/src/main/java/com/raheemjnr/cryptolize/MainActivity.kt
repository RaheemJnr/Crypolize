package com.raheemjnr.cryptolize

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.google.accompanist.pager.ExperimentalPagerApi
import com.raheemjnr.cryptolize.navigation.MainScreenNavigation
import com.raheemjnr.cryptolize.ui.theme.CryptolizeTheme

class MainActivity : ComponentActivity() {

    @OptIn(
        ExperimentalPagerApi::class, ExperimentalAnimationApi::class,
        ExperimentalMaterialApi::class
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //  makeFullScreen()
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