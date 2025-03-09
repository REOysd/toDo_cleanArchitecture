package com.example.todo_cleanarchitecture.feature.home

data class ViewState(
    val isLoading: Boolean? = null,
    val error : String? = null,
)

sealed class HomeEvent {
}
