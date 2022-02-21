package com.example.cryptolize.utils

import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.R
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.airbnb.lottie.compose.*
import kotlin.math.max


@Composable
fun LottieLoadingView(showText: Boolean) {

// to keep track if the animation is playing
// and play pause accordingly
    var isPlaying by remember { mutableStateOf(true) }

// for speed
    val speed by remember { mutableStateOf(1f) }

    // remember lottie composition, which
// accepts the lottie composition result
    val composition by rememberLottieComposition(

        LottieCompositionSpec
            // here `code` is the file name of lottie file
            // use it accordingly
            .RawRes(com.example.cryptolize.R.raw.cryptolize_loading_anim)
    )

    // to control the animation
    val progress by animateLottieCompositionAsState(
        // pass the composition created above
        composition,

        // Iterates Forever
        iterations = LottieConstants.IterateForever,

        // pass isPlaying we created above,
        // changing isPlaying will recompose
        // Lottie and pause/play
        isPlaying = isPlaying,

        // pass speed we created above,
        // changing speed will increase Lottie
        speed = speed,

        // this makes animation to restart
        // when paused and play
        // pass false to continue the animation
        // at which is was paused
        restartOnPlay = false

    )
    // Column Composable
    Column(
        Modifier
            .background(Color.White)
            .fillMaxWidth()
            .requiredSize(100.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        // LottieAnimation
        // Pass the composition
        // and the progress state
        if (showText) {
            Text(text = "Loading")
        }
        //
        LottieAnimation(
            composition,
            progress,
            modifier = Modifier.size(400.dp),

            alignment = Alignment.Center
        )



    }


}
