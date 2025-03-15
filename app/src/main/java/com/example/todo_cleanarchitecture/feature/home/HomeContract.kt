package com.example.todo_cleanarchitecture.feature.home

import com.example.todo_cleanarchitecture.domain.model.Todo

data class ViewState(
    val isLoading: Boolean? = null,
    val error : String? = null,
    val todoList : List<Todo> = emptyList(),
) {
    companion object {
        fun initial() = ViewState()
    }
}

sealed class HomeEvent {
    object LoadTodo : HomeEvent()
    object FetchTodoList : HomeEvent()
    data class DeleteTodo(val todo: Todo) : HomeEvent()
}
