package com.example.todo_cleanarchitecture.feature.todo

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.example.todo_cleanarchitecture.core.base.BaseViewModel
import com.example.todo_cleanarchitecture.domain.model.Todo
import com.example.todo_cleanarchitecture.domain.usecase.InsertTodoUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TodoViewModel @Inject constructor(
    private val InsertTodoUseCase: InsertTodoUseCase,
) : BaseViewModel<ViewState, TodoEvent>() {

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
        }
    }

    private fun loadTodo() {
        updateState((viewState.value ?: ViewState()).copy(isLoading = false))
    }

    private fun editTitle(title: String) {
        updateState((viewState.value ?: ViewState()).copy(titleText = title))
    }

    private fun editDescription(description: String) {
        updateState((viewState.value ?: ViewState()).copy(descriptionText = description))
    }

    private fun addTodo() {
        val currentState = viewState.value ?: ViewState()
        val newTodo = Todo(
            title = currentState.titleText ?: "",
            description = currentState.descriptionText ?: "",
        )
        if (currentState.titleText == "" || currentState.descriptionText == "") {
            updateState((viewState.value ?: ViewState()).copy(error = "Please fill in all fields"))
            return
        }

        viewModelScope.launch {
            InsertTodoUseCase(newTodo)
            Log.d("TodoViewModel", "Adding new Todo: $newTodo")
        }
    }

    override fun onCleared() {
        super.onCleared()
        Log.d("TodoViewModel", "ViewModel is being cleared")
    }
}