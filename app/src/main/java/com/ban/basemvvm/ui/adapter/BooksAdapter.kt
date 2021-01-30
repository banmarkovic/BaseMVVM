package com.ban.basemvvm.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ban.basemvvm.R
import com.ban.basemvvm.data.model.Book
import kotlinx.android.synthetic.main.item_book.view.*

class BooksAdapter(
    private val books: MutableList<Book>
) : RecyclerView.Adapter<BooksAdapter.BookViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        return BookViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_book, parent, false)
        )
    }

    override fun getItemCount(): Int = books.size

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        holder.bind(books[position])
    }

    inner class BookViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(bookItem: Book) = with(itemView) {
            titleTV.text = bookItem.title
            pageCountTV.text = bookItem.pageCount.toString()
        }
    }
}