package com.example.todo_cleanarchitecture.data.local.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.todo_cleanarchitecture.data.local.dao.TodoDao
import com.example.todo_cleanarchitecture.data.local.entity.TodoEntity

@Database(
    entities = [TodoEntity::class],
    version = 1,
    exportSchema = false,
)
abstract class TodoDatabase: RoomDatabase() {
    abstract fun todoDao(): TodoDao

   companion object {
       @Volatile
       private var INSTANCE: TodoDatabase? = null

       fun getDatabase(context: Context): TodoDatabase {
           return INSTANCE ?: synchronized(this) {
               val instance = Room.databaseBuilder(
                   context.applicationContext,
                   TodoDatabase::class.java,
                   "todo_database"
               ).build()
               INSTANCE = instance
               instance
           }
       }
   }
}