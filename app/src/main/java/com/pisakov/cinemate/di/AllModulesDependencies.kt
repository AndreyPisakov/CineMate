package com.pisakov.cinemate.di

import com.pisakov.createSessionScreen.di.CreateSessionScreenDependencies
import com.pisakov.favorite.di.FavoriteScreenDependencies
import com.pisakov.mainScreen.di.MainScreenDependencies
import com.pisakov.profile.di.ProfileScreenDependencies
import com.pisakov.search.di.SearchScreenDependencies
import javax.inject.Inject

class AllModulesDependencies @Inject constructor(
    val mainScreenDependencies: MainScreenDependencies,
    val searchScreenDependencies: SearchScreenDependencies,
    val favoriteScreenDependencies: FavoriteScreenDependencies,
    val profileScreenDependencies: ProfileScreenDependencies,
    val createSessionScreenDependencies: CreateSessionScreenDependencies
)