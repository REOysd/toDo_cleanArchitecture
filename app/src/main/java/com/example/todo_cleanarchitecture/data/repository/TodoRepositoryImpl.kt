package com.example.todo_cleanarchitecture.data.repository

import com.example.todo_cleanarchitecture.data.local.dao.TodoDao
import com.example.todo_cleanarchitecture.data.mapper.toModel
import com.example.todo_cleanarchitecture.data.mapper.toEntity
import com.example.todo_cleanarchitecture.domain.model.Todo
import com.example.todo_cleanarchitecture.domain.repository.TodoRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class TodoRepositoryImpl @Inject constructor(
    private val todoDao: TodoDao
) : TodoRepository {
    override fun getAll(): Flow<List<Todo>> {
        return todoDao.getAll().map { entities ->
            entities.map { it.toModel() }
        }
    }

    override suspend fun insertTodo(todo: Todo): Long {
        return todoDao.insertTodo(todo.toEntity())
    }

    override suspend fun updateTodo(todo: Todo) {
        todoDao.updateTodo(todo.toEntity())
    }

    override suspend fun deleteTodo(todo: Todo) {
        todoDao.deleteTodo(todo.toEntity())
    }

    override suspend fun getTodoById(id: Long): Todo? {
        return todoDao.getTodoById(id)?.toModel()
    }
}