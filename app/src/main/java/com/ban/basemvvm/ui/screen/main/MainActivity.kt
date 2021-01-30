package com.ban.basemvvm.ui.screen.main

import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.ban.basemvvm.R
import com.ban.basemvvm.data.model.Book
import com.ban.basemvvm.ui.adapter.BooksAdapter
import com.ban.basemvvm.ui.screen.BaseActivity
import com.ban.basemvvm.viewmodel.books.BooksViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    private val booksViewModel by lazy {
        ViewModelProvider(this, viewModelProviderFactory).get(BooksViewModel::class.java)
    }

    private val books = mutableListOf<Book>()
    private val booksAdapter by lazy {
        BooksAdapter(books)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        configureUI()
        observeBooksViewModel()
    }

    private fun configureUI() {
        activityMainRV.setHasFixedSize(true)
        activityMainRV.adapter = booksAdapter
    }

    private fun observeBooksViewModel() {
        booksViewModel.booksResp().observe(
            this,
            Observer {
                books.clear()
                books.addAll(it)
                booksAdapter.notifyDataSetChanged()
            }
        )
    }
}
