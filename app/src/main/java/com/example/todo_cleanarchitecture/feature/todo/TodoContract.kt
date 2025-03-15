package com.example.todo_cleanarchitecture.feature.todo

data class ViewState(
    val isLoading: Boolean? = null,
    val error: String? = null,
    val titleText: String? = null,
    val descriptionText: String? = null,
) {
    companion object {
        fun initial() = ViewState()
    }
}

sealed class TodoEvent {
    object  LoadTodo: TodoEvent()
    data class EditTitle(val title: String): TodoEvent()
    data class EditDescription(val description: String): TodoEvent()
    object AddTodo : TodoEvent()
    data class GetTodoById(val id: Long): TodoEvent()
    data class UpdateTodo(val id: Long): TodoEvent()
}
