package com.example.todo_cleanarchitecture.feature.todo

import com.example.todo_cleanarchitecture.core.base.BaseViewModel
import javax.inject.Inject

class TodoViewModel @Inject constructor(

) : BaseViewModel<ViewState, TodoEvent>() {
    override fun onTriggerEvent(event: TodoEvent) {
        TODO("Not yet implemented")
    }
}