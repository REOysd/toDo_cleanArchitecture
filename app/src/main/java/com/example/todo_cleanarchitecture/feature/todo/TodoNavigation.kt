package com.example.todo_cleanarchitecture.feature.todo

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.todo_cleanarchitecture.core.DestinationRoute.TODO_SCREEN_ROUTE

fun NavGraphBuilder.todoNavGraph(navController: NavController) {
     composable(route = TODO_SCREEN_ROUTE) {
         TodoScreen(navController)
     }
}