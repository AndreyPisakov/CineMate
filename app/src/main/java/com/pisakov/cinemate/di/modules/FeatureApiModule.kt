package com.pisakov.cinemate.di.modules

import com.pisakov.createSessionScreen.api.CreateSessionScreenApi
import com.pisakov.createSessionScreen.api.CreateSessionScreenImpl
import com.pisakov.navigation.AppRouter
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
interface FeatureApiModule {

    @Binds
    @Singleton
    fun bindCreateSessionScreenApi(impl: CreateSessionScreenImpl): CreateSessionScreenApi

    companion object {

        @Provides
        @Singleton
        fun provideCreateSessionScreenImpl(appRouter: AppRouter): CreateSessionScreenImpl {
            return CreateSessionScreenImpl(appRouter)
        }
    }
}

object FeatureApiInjectConstants {
    const val MAIN_SCREEN_API = "MAIN_SCREEN_API"
    const val SEARCH_SCREEN_API = "SEARCH_SCREEN_API"
    const val FAVORITE_SCREEN_API = "FAVORITE_SCREEN_API"
    const val PROFILE_SCREEN_API = "PROFILE_SCREEN_API"
}