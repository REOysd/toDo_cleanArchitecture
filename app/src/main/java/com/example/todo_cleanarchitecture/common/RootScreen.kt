package com.example.todo_cleanarchitecture.common

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.todo_cleanarchitecture.common.navigation.AppNavHost
import com.example.todo_cleanarchitecture.ui.theme.ToDo_cleanArchitectureTheme

@Composable
fun RootScreen() {
    val navController = rememberNavController()

    ToDo_cleanArchitectureTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            AppNavHost(
                navController = navController,
                modifier = Modifier.padding(innerPadding),
            )
        }
    }
}