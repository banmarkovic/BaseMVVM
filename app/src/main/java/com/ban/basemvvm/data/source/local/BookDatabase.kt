package com.ban.basemvvm.data.source.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ban.basemvvm.data.model.Book

@Database(entities = [Book::class], version = 2)
abstract class BookDatabase : RoomDatabase() {
    abstract fun bookDao(): BooksDao
}