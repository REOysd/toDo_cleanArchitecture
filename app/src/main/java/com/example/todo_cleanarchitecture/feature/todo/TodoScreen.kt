package com.example.todo_cleanarchitecture.feature.todo

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController

@Composable
fun TodoScreen(
    navController: NavController,
    viewModel: TodoViewModel = hiltViewModel(),
    todoId: Long? = null
) {
    val viewState = viewModel.viewState.collectAsState()

    LaunchedEffect(todoId) {
        if (todoId != null) {
            viewModel.onTriggerEvent(TodoEvent.GetTodoById(todoId))
        }
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = {
            navController.popBackStack()
            if (todoId != null) {
                viewModel.onTriggerEvent(TodoEvent.UpdateTodo(todoId))
            } else {
                viewModel.onTriggerEvent(TodoEvent.AddTodo)
            }
        }) {
            Text("todo screen")
        }

        TextField(
            value = viewState.value.titleText ?: "",
            onValueChange = { viewModel.onTriggerEvent(TodoEvent.EditTitle(it)) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp)
        )
        Spacer(modifier = Modifier.height(24.dp))
        TextField(
            value = viewState.value.descriptionText ?: "",
            onValueChange = { viewModel.onTriggerEvent(TodoEvent.EditDescription(it)) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp)
        )
    }
}