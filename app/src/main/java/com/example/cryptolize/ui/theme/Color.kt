package com.example.cryptolize.ui.theme

import androidx.compose.material.Colors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.compositeOver

val Purple200 = Color(0xFFBB86FC)
val Purple500 = Color(0xFF6200EE)
val Purple700 = Color(0xFF3700B3)
val Teal200 = Color(0xFF03DAC5)


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