package com.ban.basemvvm.di.uimodule

import android.app.Activity
import androidx.lifecycle.ViewModel
import com.ban.basemvvm.di.ViewModelKey
import com.ban.basemvvm.ui.screen.main.MainActivity
import com.ban.basemvvm.viewmodel.books.BooksViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap


@Module(includes = [BaseActivityModule::class])
abstract class MainActivityModule {
    @Binds
    abstract fun provideActivity(activity: MainActivity): Activity

    @Binds
    @IntoMap
    @ViewModelKey(BooksViewModel::class)
    abstract fun bindBooksViewModel(viewModel: BooksViewModel): ViewModel
}
