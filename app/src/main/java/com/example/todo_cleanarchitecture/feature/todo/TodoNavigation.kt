package com.example.todo_cleanarchitecture.feature.todo

import android.util.Log
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.todo_cleanarchitecture.core.DestinationRoute.TODO_SCREEN_ROUTE

fun NavGraphBuilder.todoNavGraph(navController: NavController) {
     composable(
         route = TODO_SCREEN_ROUTE,
         arguments = listOf(
             navArgument("todoId") {
                 type = NavType.StringType
                 nullable = true
             }
         )
     ) { backStackEntry ->
         val todoId = backStackEntry.arguments?.getString("todoId")?.toLongOrNull()
         TodoScreen(
             navController = navController,
             todoId = todoId
             )
     }
}