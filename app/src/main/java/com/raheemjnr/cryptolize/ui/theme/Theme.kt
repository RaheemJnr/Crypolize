package com.raheemjnr.cryptolize.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorPalette = darkColors(
    primary = PrimaryColor,
    primaryVariant = PrimaryDarkColor,
    onPrimary = PrimaryColor,
    secondary = SecondaryColor,
    secondaryVariant = SecondaryLightColor,
    onSecondary = PrimaryColor,
    onError = Color.Red,
    onBackground = Color.White,
    onSurface = Color.White,
    surface = PrimaryTextColor
)

private val LightColorPalette = lightColors(
    primary = PrimaryTextColor,
    primaryVariant = PrimaryDarkColor,
    onPrimary = PrimaryTextColor,
    secondary = SecondaryColor,
    secondaryVariant = SecondaryLightColor,
    onSecondary = SecondaryTextColor,
    onError = Color.Red,
    onBackground = Color.Black,
    surface = PrimaryColor


    /* Other default colors to override
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
    */
)

@Composable
fun CryptolizeTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable() () -> Unit
) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}