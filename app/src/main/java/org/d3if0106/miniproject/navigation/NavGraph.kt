package org.d3if0106.miniproject.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import org.d3if0106.miniproject.screen.AboutUs
import org.d3if0106.miniproject.screen.MainScreen

@Composable
fun navGraph(navController: NavHostController = rememberNavController()) {
    NavHost(
        navController = navController,
        startDestination = Screen.mainScreen.route
    ) {
        composable(route = Screen.mainScreen.route) {
            MainScreen(navController)
        }
        composable(route = Screen.aboutUs.route) {
            AboutUs(navController)
        }
    }
}

