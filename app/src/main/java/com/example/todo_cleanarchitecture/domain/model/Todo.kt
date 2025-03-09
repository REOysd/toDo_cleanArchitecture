package com.example.todo_cleanarchitecture.domain.model

data class Todo(
    val id: Long = 0,
    val title: String,
    val description: String,
    val createAt: Long = System.currentTimeMillis(),
)
