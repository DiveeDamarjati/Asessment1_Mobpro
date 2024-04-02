package org.d3if0106.miniproject.navigation

sealed class Screen(val route: String) {
    data object mainScreen: Screen("main")
    data object aboutUs: Screen("aboutus")
}