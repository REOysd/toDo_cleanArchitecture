package com.example.todo_cleanarchitecture.feature.home

import com.example.todo_cleanarchitecture.core.base.BaseViewModel
import com.example.todo_cleanarchitecture.feature.todo.ViewState
import javax.inject.Inject

class HomeViewModel @Inject constructor(

) : BaseViewModel<ViewState, HomeEvent>() {
    override fun onTriggerEvent(event: HomeEvent) {
        TODO("Not yet implemented")
    }

}