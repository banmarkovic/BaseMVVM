package com.ban.basemvvm.data.repository

import com.ban.basemvvm.data.model.Book
import com.ban.basemvvm.data.source.local.BooksDao
import com.ban.basemvvm.data.source.remote.ApiService
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class BooksRepository @Inject constructor(
    private val apiService: ApiService,
    private val booksDao: BooksDao
) {

    fun getBooks(): Observable<List<Book>> =
        getBooksFromApi()
            .onErrorResumeNext { _: Throwable ->
                return@onErrorResumeNext getBooksFromDb()
            }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())

    private fun getBooksFromApi(): Observable<List<Book>> =
        apiService.getBooks()
            .doOnNext {
                for (item in it) {
                    booksDao.insertBook(item)
                }
            }

    private fun getBooksFromDb(): Observable<List<Book>> =
        booksDao.queryBooks()
            .toObservable()
}