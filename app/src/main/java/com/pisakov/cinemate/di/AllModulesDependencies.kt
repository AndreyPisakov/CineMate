package com.pisakov.cinemate.di

import com.pisakov.navigation.screenDependencies.FavoriteScreenDependencies
import com.pisakov.navigation.screenDependencies.MainScreenDependencies
import com.pisakov.navigation.screenDependencies.ProfileScreenDependencies
import com.pisakov.navigation.screenDependencies.SearchScreenDependencies
import javax.inject.Inject

class AllModulesDependencies @Inject constructor(
    val mainScreenDependencies: MainScreenDependencies,
    val searchScreenDependencies: SearchScreenDependencies,
    val favoriteScreenDependencies: FavoriteScreenDependencies,
    val profileScreenDependencies: ProfileScreenDependencies,
)