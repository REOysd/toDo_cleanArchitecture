package com.example.todo_cleanarchitecture.feature.home

import androidx.lifecycle.viewModelScope
import com.example.todo_cleanarchitecture.core.base.BaseViewModel
import com.example.todo_cleanarchitecture.domain.model.Todo
import com.example.todo_cleanarchitecture.domain.usecase.DeleteTodoUseCase
import com.example.todo_cleanarchitecture.domain.usecase.GetAllUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getAllUseCase: GetAllUseCase,
    private val deleteTodoUseCase: DeleteTodoUseCase
) : BaseViewModel<ViewState, HomeEvent>(ViewState.initial()) {
    override fun onTriggerEvent(event: HomeEvent) {
        when (event) {
            is HomeEvent.LoadTodo -> {
                loadTodo()
            }
            is HomeEvent.FetchTodoList -> {
                fetchTodoList()
            }
            is HomeEvent.DeleteTodo -> {
                deleteTodo(event.todo)
            }
        }
    }

    init {
        fetchTodoList()
    }

    private fun loadTodo() {
        updateState(viewState.value.copy(isLoading = false))
    }

    private fun fetchTodoList() {
        viewModelScope.launch {
            getAllUseCase.invoke().collect { todoList ->
                updateState(viewState.value.copy(todoList = todoList))
            }
        }
    }

    private fun deleteTodo(todo: Todo) {
        viewModelScope.launch {
            deleteTodoUseCase(todo)
        }
    }
}