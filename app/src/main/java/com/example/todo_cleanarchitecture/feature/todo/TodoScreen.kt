package com.example.todo_cleanarchitecture.feature.todo

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.todo_cleanarchitecture.core.DestinationRoute.HOME_SCREEN_ROUTE

@Composable
fun TodoScreen(navController: NavController) {
    Column {
        Button(onClick = { navController.navigate(HOME_SCREEN_ROUTE) }) {
            Text("todo screen")
        }
    }
}