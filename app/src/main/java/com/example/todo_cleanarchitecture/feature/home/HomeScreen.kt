package com.example.todo_cleanarchitecture.feature.home

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.todo_cleanarchitecture.core.DestinationRoute.TODO_SCREEN_ROUTE

@Composable
fun HomeScreen(navController: NavController) {
    Column {
        Button(onClick = { navController.navigate(TODO_SCREEN_ROUTE) }) {

        }
    }
}