package com.example.todo_cleanarchitecture.core.base

import android.util.Log
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

abstract class BaseViewModel<viewState, Event> : ViewModel() {
    private val _viewState = MutableStateFlow<viewState?>(null)
    val viewState = _viewState.asStateFlow()

    fun updateState(viewState: viewState) {
        _viewState.value = viewState
    }
    abstract  fun onTriggerEvent(event: Event)
}