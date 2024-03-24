package com.pisakov.createSessionScreen.api

import com.pisakov.core.BaseFeatureApi
import com.pisakov.core.BaseFeatureResult
import com.pisakov.navigation.AppRouter
import com.pisakov.navigation.CreateSessionDestination
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import javax.inject.Inject

interface CreateSessionScreenApi : BaseFeatureApi<Any?, Unit>

class CreateSessionScreenImpl @Inject constructor(
    private val appRouter: AppRouter
) : CreateSessionScreenApi {

    override fun execute(args: Any?) {
        appRouter.tryNavigateTo(route = CreateSessionDestination())
    }

    internal val internalFeatureResult: MutableSharedFlow<BaseFeatureResult<Unit>> = MutableSharedFlow()
    override val featureResult: SharedFlow<BaseFeatureResult<Unit>>
        get() = internalFeatureResult
}