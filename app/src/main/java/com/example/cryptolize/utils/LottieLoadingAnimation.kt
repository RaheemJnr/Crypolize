package com.example.cryptolize.utils

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.LottieComposition
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import java.util.*


@Composable
fun LottieAnimation(showMessage: Boolean, message: String? = null, composition: LottieComposition) {

// to keep track if the animation is playing
// and play pause accordingly
    val isPlaying by remember { mutableStateOf(true) }

// for speed
    val speed by remember { mutableStateOf(1f) }

    // remember lottie composition, which
// accepts the lottie composition result


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
        if (showMessage) {
            if (message != null) {
                Text(
                    text = message.uppercase(Locale.getDefault()),
                    fontWeight = FontWeight.Bold,
                )
            }
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
