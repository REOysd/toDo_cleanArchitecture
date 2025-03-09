package com.example.todo_cleanarchitecture.feature.todo

data class ViewState(
    val isLoading: Boolean? = null,
    val error: String? = null,
)

sealed class TodoEvent {
}
