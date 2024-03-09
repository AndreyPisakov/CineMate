package com.pisakov.core

import kotlinx.coroutines.flow.Flow

interface BaseFeatureApi<ARGS, RESULT> {

    val featureResult: Flow<BaseFeatureResult<RESULT>>

    fun execute(args: ARGS)
}

sealed interface BaseFeatureResult<out T> {

    data class Success<T>(val result: T) : BaseFeatureResult<T>

    data class Error(val throwable: Throwable?, val message: String?) : BaseFeatureResult<Nothing>

    object Finished : BaseFeatureResult<Nothing>
}