package com.ban.basemvvm.di

import com.ban.basemvvm.BaseMVVMApplication
import com.ban.basemvvm.di.configmodule.ActivityBuilderModule
import com.ban.basemvvm.di.configmodule.AppModule
import com.ban.basemvvm.di.configmodule.NetModule
import com.ban.basemvvm.di.scope.ApplicationContext
import dagger.Component
import dagger.android.AndroidInjector
import javax.inject.Singleton

@ApplicationContext
@Singleton
@Component(modules = [
    ActivityBuilderModule::class,
    AppModule::class,
    NetModule::class
])
interface AppComponent : AndroidInjector<BaseMVVMApplication>
