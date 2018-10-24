package com.tiptop.androidbase.di

import com.tiptop.androidbase.BaseApp
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton


@Singleton
@Component(modules = [(AndroidSupportInjectionModule::class), (AppModule::class), (RepositoryModule::class), (InjectorsModule::class)])
interface AppComponent: AndroidInjector<BaseApp> {
    @Component.Builder
    abstract class Builder: AndroidInjector.Builder<BaseApp>()
}
