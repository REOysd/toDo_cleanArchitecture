package com.example.todo_cleanarchitecture.domain.repository

import com.example.todo_cleanarchitecture.domain.model.Todo
import kotlinx.coroutines.flow.Flow

interface TodoRepository {

    //　Todo Entityを利用するとdataレイヤーに依存してしまうため利用しない
    fun getAll(): Flow<List<Todo>>
    suspend fun insertTodo(todo: Todo) : Long
    suspend fun updateTodo(todo: Todo)
    suspend fun deleteTodo(todo: Todo)
    suspend fun getTodoById(id: Long) : Todo?
}