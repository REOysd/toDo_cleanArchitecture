package com.example.todo_cleanarchitecture.domain.usecase

import com.example.todo_cleanarchitecture.domain.model.Todo
import com.example.todo_cleanarchitecture.domain.repository.TodoRepository
import javax.inject.Inject

class GetTodoByIdUseCase @Inject constructor(
    private val todoRepository: TodoRepository
) {
    suspend operator fun invoke(id : Long): Todo? {
        return todoRepository.getTodoById(id)
    }
}