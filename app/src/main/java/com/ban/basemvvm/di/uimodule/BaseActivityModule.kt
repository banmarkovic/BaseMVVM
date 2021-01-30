package com.ban.basemvvm.di.uimodule

import android.app.Activity
import com.ban.basemvvm.ui.screen.BaseActivity
import dagger.Binds
import dagger.Module

@Module
abstract class BaseActivityModule {
    @Binds
    abstract fun provideActivity(activity: BaseActivity): Activity
}
