package com.example.todo_cleanarchitecture.feature.todo

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.example.todo_cleanarchitecture.core.base.BaseViewModel
import com.example.todo_cleanarchitecture.domain.model.Todo
import com.example.todo_cleanarchitecture.domain.usecase.GetTodoByIdUseCase
import com.example.todo_cleanarchitecture.domain.usecase.InsertTodoUseCase
import com.example.todo_cleanarchitecture.domain.usecase.UpdateTodoUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TodoViewModel @Inject constructor(
    private val insertTodoUseCase: InsertTodoUseCase,
    private val getTodoByIdUseCase: GetTodoByIdUseCase,
    private val updateTodoUseCase: UpdateTodoUseCase
) : BaseViewModel<ViewState, TodoEvent>(ViewState.initial()) {

    override fun onTriggerEvent(event: TodoEvent) {
        when(event) {
            is TodoEvent.LoadTodo -> {
                loadTodo()
            }
            is TodoEvent.EditTitle -> {
                editTitle(title = event.title)
            }
            is TodoEvent.EditDescription -> {
                editDescription(description = event.description)
            }
            is TodoEvent.AddTodo -> {
                addTodo()
            }
            is TodoEvent.GetTodoById -> {
                getTodoById(id = event.id)
            }
            is TodoEvent.UpdateTodo -> {
                updateTodo(event.id)
            }
        }
    }

    private fun loadTodo() {
        updateState(viewState.value.copy(isLoading = false))
    }

    private fun editTitle(title: String) {
        updateState(viewState.value.copy(titleText = title))
    }

    private fun editDescription(description: String) {
        updateState(viewState.value.copy(descriptionText = description))
    }

    private fun addTodo() {
        val currentState = viewState.value
        val newTodo = Todo(
            title = currentState.titleText ?: "",
            description = currentState.descriptionText ?: "",
        )
        if (currentState.titleText == "" || currentState.descriptionText == "") {
            updateState(viewState.value.copy(error = "Please fill in all fields"))
            return
        }
        viewModelScope.launch {
            insertTodoUseCase(newTodo)
            Log.d("TodoViewModel", "Adding new Todo: $newTodo")
        }
    }

    private fun getTodoById(id: Long) {
        viewModelScope.launch {
            val todo = getTodoByIdUseCase(id)
            Log.d("TodoViewModel", "取得したTodo: $todo")
            if (todo != null) {
                Log.d("TodoViewModel", "Todo詳細 - ID: ${todo.id}, タイトル: ${todo.title}, 説明: ${todo.description}")
                editTitle(title = todo.title)
                editDescription(description = todo.description)
            } else {
                Log.d("TodoViewModel", "ID: $id のTodoが見つかりませんでした")
                editTitle(title = "")
                editDescription(description = "")
            }
        }
    }

    private fun updateTodo(id: Long) {
        val todo = Todo(
            id = id,
            title = viewState.value.titleText ?: "",
            description = viewState.value.descriptionText ?: ""
        )
        viewModelScope.launch {
            updateTodoUseCase(todo)
        }
    }

    override fun onCleared() {
        super.onCleared()
        Log.d("TodoViewModel", "ViewModel is being cleared")
    }
}