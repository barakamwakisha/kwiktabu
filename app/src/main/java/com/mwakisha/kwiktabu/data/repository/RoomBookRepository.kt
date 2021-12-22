package com.mwakisha.kwiktabu.data.repository

import androidx.paging.PagingSource
import com.mwakisha.kwiktabu.data.AppDatabase
import com.mwakisha.kwiktabu.data.entity.Book
import javax.inject.Inject

class RoomBookRepository @Inject constructor(
    private val db: AppDatabase
) {
    fun getAllBooks(): PagingSource<Int, Book> {
        return db.bookDao().getAll()
    }
}