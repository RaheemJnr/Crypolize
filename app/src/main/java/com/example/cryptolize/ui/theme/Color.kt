package com.example.cryptolize.ui.theme

import androidx.compose.material.Colors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.compositeOver

val PrimaryColor = Color(0xFFffffff)
val PrimaryLightColor = Color(0xFFffffff)
val PrimaryDarkColor = Color(0xFFcccccc)
val PrimaryTextColor = Color(0xFF000000)
//
val SecondaryColor = Color(0xFFffd700)
val SecondaryLightColor = Color(0xFFffff52)
val SecondaryDarkColor = Color(0xFFc7a600)
val SecondaryTextColor = Color(0xFF000000)



//
val green200 = Color(0xffa5d6a7)
val green500 = Color(0xff4caf50)
val green700 = Color(0xff388e3c)

//
val red = Color(0xFFEE1D52)
val orange = Color(0xFFF56040)

//
val gradientGreenColors = listOf(green200, green500, green700)
val gradientRedColors = listOf(orange, red)

/**
 * Return the fully opaque color that results from compositing [onSurface] atop [surface] with the
 * given [alpha]. Useful for situations where semi-transparent colors are undesirable.
 */
@Composable
fun Colors.compositedOnSurface(alpha: Float): Color {
    return onSurface.copy(alpha = alpha).compositeOver(surface)
}