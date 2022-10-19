package com.arslan.news.presentation

import androidx.annotation.DrawableRes
import com.arslan.resources.R

sealed class BottomBarScreen(
    val route: String,
    val title: String,
    @DrawableRes val icon: Int
) {
    object Home : BottomBarScreen(
        route = "home",
        title = "Home",
        icon = R.drawable.tab_home
    )

    object Explore : BottomBarScreen(
        route = "explore",
        title = "Explore",
        icon = R.drawable.tab_explore
    )

    object Bookmark : BottomBarScreen(
        route = "bookmark",
        title = "Bookmark",
        icon = R.drawable.tab_bookmark
    )

    object Profile : BottomBarScreen(
        route = "profile",
        title = "Profile",
        icon = R.drawable.tab_profile
    )
}