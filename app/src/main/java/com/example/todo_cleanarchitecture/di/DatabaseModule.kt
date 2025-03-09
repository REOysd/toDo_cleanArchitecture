package com.example.todo_cleanarchitecture.di

import android.content.Context
import com.example.todo_cleanarchitecture.data.local.dao.TodoDao
import com.example.todo_cleanarchitecture.data.local.database.TodoDatabase
import com.example.todo_cleanarchitecture.data.repository.TodoRepositoryImpl
import com.example.todo_cleanarchitecture.domain.repository.TodoRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideTodoDatabase(@ApplicationContext context: Context): TodoDatabase {
        return TodoDatabase.getDatabase(context)
    }

    @Provides
    @Singleton
    fun provideTodoDao(database: TodoDatabase): TodoDao {
        return database.todoDao()
    }

    @Provides
    @Singleton
    fun provideTodoRepository(todoDao: TodoDao): TodoRepository {
        return TodoRepositoryImpl(todoDao)
    }
}