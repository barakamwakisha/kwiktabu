package com.mwakisha.kwiktabu.ui.books

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.mwakisha.kwiktabu.data.entity.Book
import com.mwakisha.kwiktabu.data.repository.RoomBookRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class BooksViewModel @Inject constructor(
    private val repository: RoomBookRepository
) : ViewModel() {

    val allBooks: Flow<PagingData<Book>> = Pager(
        config = PagingConfig(
            pageSize = 20,
            enablePlaceholders = true,
            maxSize = 200
        )
    ) {
        repository.getAllBooks()
    }
        .flow
        .cachedIn(viewModelScope)
}