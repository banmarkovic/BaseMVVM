package com.ban.basemvvm.di.configmodule

import com.ban.basemvvm.di.scope.ActivityContext
import com.ban.basemvvm.di.uimodule.MainActivityModule
import com.ban.basemvvm.ui.screen.main.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.android.support.AndroidSupportInjectionModule

@Module(includes = [
    AndroidSupportInjectionModule::class,
    ViewModelFactoryModule::class
])
abstract class ActivityBuilderModule {

    @ActivityContext
    @ContributesAndroidInjector(modules = [MainActivityModule::class])
    abstract fun mainActivity(): MainActivity
}
