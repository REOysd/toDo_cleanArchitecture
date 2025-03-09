package com.example.todo_cleanarchitecture.data.mapper

import com.example.todo_cleanarchitecture.data.local.entity.TodoEntity
import com.example.todo_cleanarchitecture.domain.model.Todo

fun Todo.toEntity(): TodoEntity {
    return TodoEntity(
        id = id,
        title = title,
        description = description,
        createAt = System.currentTimeMillis(),
    )
}