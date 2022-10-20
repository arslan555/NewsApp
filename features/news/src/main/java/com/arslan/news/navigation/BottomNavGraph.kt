package com.arslan.news.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.arslan.bookmark.presentation.BookmarkScreen
import com.arslan.explore.presentation.ExploreScreen
import com.arslan.home.presentation.HomeScreen
import com.arslan.news.presentation.BottomBarScreen
import com.arslan.profile.presentation.ProfileScreen

@Composable
fun BottomNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = BottomBarScreen.Home.route
    ) {
        composable(route = BottomBarScreen.Home.route) {
            HomeScreen()
        }
        composable(route = BottomBarScreen.Explore.route) {
            ExploreScreen()
        }
        composable(route = BottomBarScreen.Bookmark.route) {
            BookmarkScreen()
        }
        composable(route = BottomBarScreen.Profile.route) {
                ProfileScreen()
        }
    }
}