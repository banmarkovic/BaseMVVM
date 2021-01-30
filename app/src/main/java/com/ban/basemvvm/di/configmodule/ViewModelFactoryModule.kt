package com.ban.basemvvm.di.configmodule

import androidx.lifecycle.ViewModelProvider
import com.ban.basemvvm.viewmodel.ViewModelProviderFactory
import dagger.Binds
import dagger.Module

@Module
abstract class ViewModelFactoryModule {
    @Binds
    abstract fun bindViewModelFactory(viewModelFactory: ViewModelProviderFactory): ViewModelProvider.Factory
}
