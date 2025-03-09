package com.example.todo_cleanarchitecture.feature.todo

import com.example.todo_cleanarchitecture.data.local.entity.TodoEntity

data class ViewState(
    val isLoading: Boolean? = null,
    val error: String? = null,
    val titleText: String? = null,
    val descriptionText: String? = null,
)

sealed class TodoEvent {
    object  LoadTodo: TodoEvent()
    data class EditTitle(val title: String): TodoEvent()
    data class EditDescription(val description: String): TodoEvent()
    object AddTodo : TodoEvent()
}
