package com.pisakov.cinemate.di

import com.pisakov.cinemate.MainActivity
import com.pisakov.cinemate.containerScreen.ContainerViewModel
import com.pisakov.cinemate.di.modules.AuthModule
import com.pisakov.cinemate.di.modules.DependenciesModule
import com.pisakov.cinemate.di.modules.FeatureApiModule
import com.pisakov.cinemate.di.modules.RepositoryModule
import com.pisakov.data.di.RepositoryProvider
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Component(modules = [AuthModule::class, DependenciesModule::class, RepositoryModule::class, FeatureApiModule::class])
@Singleton
interface AppComponent {

    fun inject(activity: MainActivity)

    fun getContainerScreenViewModel(): ContainerViewModel

    @Component.Factory
    interface Factory {

        fun create(
            @BindsInstance repositoryProvider: RepositoryProvider
        ): AppComponent
    }
}