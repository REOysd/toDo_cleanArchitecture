package com.example.todo_cleanarchitecture.feature.home

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.todo_cleanarchitecture.core.DestinationRoute.HOME_SCREEN_ROUTE

fun NavGraphBuilder.homeNavGraph(navController: NavController) {
    composable(
        route = HOME_SCREEN_ROUTE,
    ) { backStackEntry ->
        HomeScreen(navController = navController)
    }
}