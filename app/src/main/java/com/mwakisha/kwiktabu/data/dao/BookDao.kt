package com.mwakisha.kwiktabu.data.dao

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Query
import com.mwakisha.kwiktabu.data.entity.Book

@Dao
interface BookDao {
    @Query("SELECT * FROM books")
    fun getAll(): PagingSource<Int, Book>
}