package com.example.todo_cleanarchitecture.feature.home

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.todo_cleanarchitecture.core.DestinationRoute.TODO_SCREEN_ROUTE
import com.example.todo_cleanarchitecture.core.todoScreenRoute
import com.example.todo_cleanarchitecture.feature.home.common.TodoComponent

@Composable
fun HomeScreen(
    navController: NavController,
    viewModel: HomeViewModel = hiltViewModel(),
) {
    val viewState by viewModel.viewState.collectAsState()

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Button(onClick = { navController.navigate(TODO_SCREEN_ROUTE) }) {
            Text(text = "Go to Todo Screen")
        }

        LazyColumn {
            items(viewState.todoList) { todo ->
                Log.d("HomeScreen", "todo: $todo")
                TodoComponent(
                    title = todo.title,
                    description = todo.description,
                    createAt = todo.createAt.toString(),
                    onClick = {
                        navController.navigate(todoScreenRoute(todoId = todo.id))
                    },
                    onLongClick = {
                        viewModel.onTriggerEvent(HomeEvent.DeleteTodo(todo = todo))
                    }
                )
            }
        }
    }
}