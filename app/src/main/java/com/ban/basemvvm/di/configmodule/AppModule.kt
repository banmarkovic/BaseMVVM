package com.ban.basemvvm.di.configmodule

import android.app.Application
import android.content.SharedPreferences
import androidx.preference.PreferenceManager
import androidx.room.Room
import com.ban.basemvvm.data.source.local.BooksDao
import com.ban.basemvvm.data.source.local.BookDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(private val app: Application) {

    companion object {
        private const val BOOKS_DB_NAME = "books_db"
    }

    @Provides
    @Singleton
    fun provideApplication(): Application = app

    @Provides
    @Singleton
    fun provideSharedPreferences(): SharedPreferences = PreferenceManager.getDefaultSharedPreferences(app)

    @Provides
    @Singleton
    fun provideBooksDatabase(app: Application): BookDatabase =
        Room.databaseBuilder(
            app,
            BookDatabase::class.java,
            BOOKS_DB_NAME
        ).fallbackToDestructiveMigration()
        .build()


    @Provides
    @Singleton
    fun provideBooksDao(database: BookDatabase): BooksDao = database.bookDao()

}
