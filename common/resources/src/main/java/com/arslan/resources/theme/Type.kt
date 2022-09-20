package com.arslan.resources.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.arslan.resources.R

// Set of Material typography styles to start with


private val fonts = FontFamily(
    Font(
        resId = R.font.poppins_bold,
        weight = FontWeight.Bold,
        style = FontStyle.Normal
    ),
    Font(
        resId = R.font.poppins_medium,
        weight = FontWeight.Medium,
        style = FontStyle.Normal
    ),
    Font(
        resId = R.font.poppins_regular,
        weight = FontWeight.W400,
        style = FontStyle.Normal
    ),
    Font(
        resId = R.font.poppins_regular,
        weight = FontWeight.W400,
        style = FontStyle.Italic
    ),
    Font(
        resId = R.font.poppins_light,
        weight = FontWeight.Light,
        style = FontStyle.Normal
    )
)
val Typography = Typography(
    body1 = TextStyle(
        fontFamily = fonts,
        fontWeight = FontWeight.W400,
        fontSize = 14.sp
    )
    /* Other default text styles to override
    button = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.W500,
        fontSize = 14.sp
    ),
    caption = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    )
    */
)