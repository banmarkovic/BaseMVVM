package com.ban.basemvvm.data.source.remote

import com.ban.basemvvm.data.model.Book
import io.reactivex.Observable
import retrofit2.http.GET

interface ApiService {

    @GET("ba4aa00a-e5df-4681-a5ef-bfeb97151506")
    fun getBooks(): Observable<List<Book>>
}