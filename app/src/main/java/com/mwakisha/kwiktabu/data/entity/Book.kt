package com.mwakisha.kwiktabu.data.entity

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(tableName = "books", indices = [Index(value = ["level"])])
data class Book(
    @PrimaryKey
    val id: Long,

    val coverUrl: String,

    val title: String,

    val level: String
)
