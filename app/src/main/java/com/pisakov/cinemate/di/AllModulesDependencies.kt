package com.pisakov.cinemate.di

import com.pisakov.favorite.di.FavoriteScreenDependencies
import com.pisakov.main_screen.di.MainScreenDependencies
import com.pisakov.profile.di.ProfileScreenDependencies
import com.pisakov.search.di.SearchScreenDependencies
import javax.inject.Inject

class AllModulesDependencies @Inject constructor(
    val mainScreenDependencies: MainScreenDependencies,
    val searchScreenDependencies: SearchScreenDependencies,
    val favoriteScreenDependencies: FavoriteScreenDependencies,
    val profileScreenDependencies: ProfileScreenDependencies,
)