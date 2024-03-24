package com.pisakov.cinemate.di.dependencies

import com.pisakov.createSessionScreen.api.CreateSessionScreenApi
import com.pisakov.mainScreen.di.MainScreenDependencies
import com.pisakov.navigation.AppRouter
import javax.inject.Inject

class MainScreenDependenciesImpl @Inject constructor(
    private val appRouter: AppRouter,
    private val createSessionScreenApi: CreateSessionScreenApi
) : MainScreenDependencies {

    override fun appRouter(): AppRouter = appRouter

    override fun createSessionScreenApi(): CreateSessionScreenApi = createSessionScreenApi
}