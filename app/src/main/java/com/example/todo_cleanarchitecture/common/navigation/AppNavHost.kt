package com.example.todo_cleanarchitecture.common.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.example.todo_cleanarchitecture.feature.home.homeNavGraph
import com.example.todo_cleanarchitecture.core.DestinationRoute.HOME_SCREEN_ROUTE
import com.example.todo_cleanarchitecture.feature.todo.todoNavGraph


@Composable
fun AppNavHost(
    navController: NavHostController,
    modifier: Modifier,
    startDestination: String = HOME_SCREEN_ROUTE,
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {
        homeNavGraph(navController)
        todoNavGraph(navController)
    }
}

