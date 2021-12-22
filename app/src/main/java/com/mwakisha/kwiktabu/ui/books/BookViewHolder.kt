package com.mwakisha.kwiktabu.ui.books

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.mwakisha.kwiktabu.R
import com.mwakisha.kwiktabu.data.entity.Book

class BookViewHolder(parent: ViewGroup): RecyclerView.ViewHolder(
    LayoutInflater.from(parent.context).inflate(R.layout.book_item, parent, false)
) {
    private val bookCover = itemView.findViewById<ImageView>(R.id.book_cover)
    private val bookName = itemView.findViewById<TextView>(R.id.book_name)
    private val bookLevel = itemView.findViewById<TextView>(R.id.book_level)

    fun bindTo(book: Book?) {
        bookCover.load(book?.coverUrl)
        bookName.text = book?.title
        bookLevel.text = book?.level
    }
}