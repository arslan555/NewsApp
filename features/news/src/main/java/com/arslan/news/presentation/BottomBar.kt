package com.arslan.news.presentation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomBarScreen(
    val route: String,
    val title: String,
    val icon: ImageVector
) {
    object Home : BottomBarScreen(
        route = "home",
        title = "Home",
        icon = Icons.Default.Home
    )

    object Explore : BottomBarScreen(
        route = "explore",
        title = "Explore",
        icon = Icons.Default.Search
    )

    object Bookmark : BottomBarScreen(
        route = "bookmark",
        title = "Bookmark",
        icon = Icons.Default.Favorite
    )

    object Profile : BottomBarScreen(
        route = "profile",
        title = "Profile",
        icon = Icons.Default.Person
    )
}