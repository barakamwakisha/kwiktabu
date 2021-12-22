package com.mwakisha.kwiktabu.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.mwakisha.kwiktabu.data.dao.BookDao
import com.mwakisha.kwiktabu.data.entity.Book

@Database(entities = [Book::class], version = 1)
abstract class AppDatabase: RoomDatabase() {

    abstract fun bookDao(): BookDao

    companion object {
        const val DATABASE_NAME = "kwiktabu_db"
    }
}