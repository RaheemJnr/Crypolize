package com.raheemjnr.cryptolize.ui.theme

import androidx.compose.material.Colors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.compositeOver

//val PrimaryColor = Color(0xFFffffff)
//val PrimaryLightColor = Color(0xFFffffff)
//val PrimaryDarkColor = Color(0xFFcccccc)
//val PrimaryTextColor = Color(0xFF000000)
////
//val SecondaryColor = Color(0xFFffd700)
//val SecondaryLightColor = Color(0xFFffff52)
//val SecondaryDarkColor = Color(0xFFc7a600)
//val SecondaryTextColor = Color(0xFF000000)



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


//M3
val md_theme_light_primary = Color(0xFF705D00)
val md_theme_light_onPrimary = Color(0xFFFFFFFF)
val md_theme_light_primaryContainer = Color(0xFFFFE173)
val md_theme_light_onPrimaryContainer = Color(0xFF221B00)
val md_theme_light_secondary = Color(0xFF705D00)
val md_theme_light_onSecondary = Color(0xFFFFFFFF)
val md_theme_light_secondaryContainer = Color(0xFFFFE16D)
val md_theme_light_onSecondaryContainer = Color(0xFF221B00)
val md_theme_light_tertiary = Color(0xFF006874)
val md_theme_light_onTertiary = Color(0xFFFFFFFF)
val md_theme_light_tertiaryContainer = Color(0xFF97F0FF)
val md_theme_light_onTertiaryContainer = Color(0xFF001F24)
val md_theme_light_error = Color(0xFFBA1A1A)
val md_theme_light_errorContainer = Color(0xFFFFDAD6)
val md_theme_light_onError = Color(0xFFFFFFFF)
val md_theme_light_onErrorContainer = Color(0xFF410002)
val md_theme_light_background = Color(0xFFFFFBFF)
val md_theme_light_onBackground = Color(0xFF1D1B16)
val md_theme_light_surface = Color(0xFFFFFBFF)
val md_theme_light_onSurface = Color(0xFF1D1B16)
val md_theme_light_surfaceVariant = Color(0xFFEAE2CF)
val md_theme_light_onSurfaceVariant = Color(0xFF4B4639)
val md_theme_light_outline = Color(0xFF7D7767)
val md_theme_light_inverseOnSurface = Color(0xFFF6F0E7)
val md_theme_light_inverseSurface = Color(0xFF33302A)
val md_theme_light_inversePrimary = Color(0xFFE7C42F)
val md_theme_light_shadow = Color(0xFF000000)
val md_theme_light_surfaceTint = Color(0xFF705D00)
val md_theme_light_outlineVariant = Color(0xFFCEC6B4)
val md_theme_light_scrim = Color(0xFF000000)

val md_theme_dark_primary = Color(0xFFE7C42F)
val md_theme_dark_onPrimary = Color(0xFF3B2F00)
val md_theme_dark_primaryContainer = Color(0xFF554500)
val md_theme_dark_onPrimaryContainer = Color(0xFFFFE173)
val md_theme_dark_secondary = Color(0xFFE9C400)
val md_theme_dark_onSecondary = Color(0xFF3A3000)
val md_theme_dark_secondaryContainer = Color(0xFF544600)
val md_theme_dark_onSecondaryContainer = Color(0xFFFFE16D)
val md_theme_dark_tertiary = Color(0xFF4FD8EB)
val md_theme_dark_onTertiary = Color(0xFF00363D)
val md_theme_dark_tertiaryContainer = Color(0xFF004F58)
val md_theme_dark_onTertiaryContainer = Color(0xFF97F0FF)
val md_theme_dark_error = Color(0xFFFFB4AB)
val md_theme_dark_errorContainer = Color(0xFF93000A)
val md_theme_dark_onError = Color(0xFF690005)
val md_theme_dark_onErrorContainer = Color(0xFFFFDAD6)
val md_theme_dark_background = Color(0xFF1D1B16)
val md_theme_dark_onBackground = Color(0xFFE8E2D9)
val md_theme_dark_surface = Color(0xFF1D1B16)
val md_theme_dark_onSurface = Color(0xFFE8E2D9)
val md_theme_dark_surfaceVariant = Color(0xFF4B4639)
val md_theme_dark_onSurfaceVariant = Color(0xFFCEC6B4)
val md_theme_dark_outline = Color(0xFF979080)
val md_theme_dark_inverseOnSurface = Color(0xFF1D1B16)
val md_theme_dark_inverseSurface = Color(0xFFE8E2D9)
val md_theme_dark_inversePrimary = Color(0xFF705D00)
val md_theme_dark_shadow = Color(0xFF000000)
val md_theme_dark_surfaceTint = Color(0xFFE7C42F)
val md_theme_dark_outlineVariant = Color(0xFF4B4639)
val md_theme_dark_scrim = Color(0xFF000000)


val seed = Color(0xFFC7A600)

/**
 * Return the fully opaque color that results from compositing [onSurface] atop [surface] with the
 * given [alpha]. Useful for situations where semi-transparent colors are undesirable.
 */
@Composable
fun Colors.compositedOnSurface(alpha: Float): Color {
    return onSurface.copy(alpha = alpha).compositeOver(surface)
}