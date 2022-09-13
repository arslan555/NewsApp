package com.arslan.resources.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
private val DarkColorPalette = darkColors(
    primary = blue,
    primaryVariant = black,
    secondary = Teal200,
    background = white,
    surface = white
)

private val LightColorPalette = lightColors(
    primary = blue,
    primaryVariant = black,
    secondary = Teal200,
    background = white,
    surface = white
)

@Composable
fun NewsAppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
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