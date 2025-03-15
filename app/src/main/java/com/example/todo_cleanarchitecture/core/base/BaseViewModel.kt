package com.example.todo_cleanarchitecture.core.base

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

abstract class BaseViewModel<ViewState : Any, Event>(
    initialState: ViewState
) : ViewModel() {
    private val _viewState = MutableStateFlow(initialState)
    val viewState: StateFlow<ViewState> = _viewState.asStateFlow()

    fun updateState(viewState: ViewState) {
        _viewState.value = viewState
    }
    abstract fun onTriggerEvent(event: Event)
}