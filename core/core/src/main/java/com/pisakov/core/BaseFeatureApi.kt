package com.pisakov.core

import kotlinx.coroutines.flow.SharedFlow

interface BaseFeatureApi<ARGS, RESULT> {

    fun execute(args: ARGS)

    val featureResult: SharedFlow<BaseFeatureResult<RESULT>>
}

sealed interface BaseFeatureResult<out T> {

    data class Success<T>(val result: T) : BaseFeatureResult<T>

    data class Error(val throwable: Throwable?, val message: String?) : BaseFeatureResult<Nothing>

    object Finished : BaseFeatureResult<Nothing>
}