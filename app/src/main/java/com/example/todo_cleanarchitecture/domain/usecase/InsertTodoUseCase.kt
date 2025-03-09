package com.example.todo_cleanarchitecture.domain.usecase

import com.example.todo_cleanarchitecture.domain.model.Todo
import com.example.todo_cleanarchitecture.domain.repository.TodoRepository
import javax.inject.Inject

class InsertTodoUseCase @Inject constructor(
    private val todoRepository: TodoRepository
) {
    suspend operator fun invoke(todo: Todo): Long{
        return todoRepository.insertTodo(todo)
    }
}