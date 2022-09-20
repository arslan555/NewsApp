package com.arslan.resources.theme

import android.annotation.SuppressLint
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@SuppressLint("ConflictingOnColor")
private val DarkColorPalette = darkColors(
    primary = blue,
    primaryVariant = black,
    secondary = Teal200,
    background = black,
    surface = black,
    onBackground = black
)

@SuppressLint("ConflictingOnColor")
private val LightColorPalette = lightColors(
    primary = blue,
    primaryVariant = black,
    secondary = Teal200,
    background = white,
    surface = white,
    onBackground = black
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