package com.pisakov.mainScreen.di

import com.pisakov.createSessionScreen.api.CreateSessionScreenApi
import com.pisakov.navigation.AppRouter

interface MainScreenDependencies {

    fun appRouter(): AppRouter

    fun createSessionScreenApi(): CreateSessionScreenApi
}