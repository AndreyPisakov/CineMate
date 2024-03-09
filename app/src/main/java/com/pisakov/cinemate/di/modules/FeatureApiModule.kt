package com.pisakov.cinemate.di.modules

import dagger.Module

@Module
interface FeatureApiModule {

}

object FeatureApiInjectConstants {
    const val MAIN_SCREEN_API = "MAIN_SCREEN_API"
    const val SEARCH_SCREEN_API = "SEARCH_SCREEN_API"
    const val FAVORITE_SCREEN_API = "FAVORITE_SCREEN_API"
    const val PROFILE_SCREEN_API = "PROFILE_SCREEN_API"
}