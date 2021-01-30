package com.ban.basemvvm.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json

@Entity(tableName = "books")
data class Book (
    @Json(name = "isbn")
    @PrimaryKey
    val isbn: String,
    @Json(name = "title")
    @ColumnInfo(name = "title")
    val title: String,
    @Json(name = "pageCount")
    @ColumnInfo(name = "page_count")
    val pageCount: Int
)