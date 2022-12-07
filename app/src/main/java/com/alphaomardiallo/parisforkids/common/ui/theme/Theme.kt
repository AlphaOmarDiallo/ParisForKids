package com.alphaomardiallo.parisforkids.common.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorPalette = darkColors(
    primary = primaryColor,
    primaryVariant = primaryLightColor,
    secondary = secondaryColor,
    background = primaryDarkColor,
    surface = primaryDarkColor,
    onPrimary = primaryTextColor,
    onSecondary = secondaryTextColor
)

private val LightColorPalette = lightColors(
    primary = primaryColor,
    primaryVariant = primaryDarkColor,
    secondary = secondaryColor,
    background = Color.White,
    surface = Color.White,
    onPrimary = primaryTextColor,
    onSecondary = secondaryTextColor
)

@Composable
fun ParisForKidsTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
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