package com.ban.basemvvm.viewmodel.books

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ban.basemvvm.data.model.Book
import com.ban.basemvvm.data.repository.BooksRepository
import io.reactivex.Observer
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import javax.inject.Inject

class BooksViewModel @Inject constructor(
    private val booksRepository: BooksRepository
) : ViewModel() {

    private val booksResp: MutableLiveData<List<Book>> = MutableLiveData()
    private val booksError: MutableLiveData<String> =  MutableLiveData()
    private val compositeDisposable = CompositeDisposable()

    fun booksResp(): LiveData<List<Book>> = booksResp
    fun booksError(): LiveData<String> = booksError

    init {
        fetchBooks()
    }

    private fun fetchBooks() {
        booksRepository.getBooks()
            .subscribe(object: Observer<List<Book>> {
                override fun onSubscribe(d: Disposable) { compositeDisposable.add(d) }

                override fun onComplete() {}

                override fun onNext(t: List<Book>) {
                    booksResp.postValue(t)
                }

                override fun onError(e: Throwable) {
                    booksError.postValue(e.message)
                }
            })
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }
}