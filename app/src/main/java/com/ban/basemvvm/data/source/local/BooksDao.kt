package com.ban.basemvvm.data.source.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ban.basemvvm.data.model.Book
import io.reactivex.Single

@Dao
interface BooksDao {
    @Query("SELECT * FROM books")
    fun queryBooks(): Single<List<Book>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertBook(book: Book)
}