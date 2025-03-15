package com.example.todo_cleanarchitecture.core

import android.util.Log
import com.example.todo_cleanarchitecture.core.DestinationRoute.TODO_SCREEN_ROUTE

object DestinationRoute {
    const val HOME_SCREEN_ROUTE = "home_screen_route"
    const val TODO_SCREEN_ROUTE = "todo_screen_route?todoId={todoId}"
}

fun todoScreenRoute(todoId: Long? = null): String {
    return if (todoId == null) {
        // todoIdがnullの場合はパラメータなしのルート
        TODO_SCREEN_ROUTE.replace("?todoId={todoId}", "")
    } else {
        // todoIdがある場合は値を置換（クエリパラメータとして）
        TODO_SCREEN_ROUTE.replace("{todoId}", todoId.toString())
    }
}