package com.pisakov.cinemate.containerScreen

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.pisakov.cinemate.di.AllModulesDependencies
import com.pisakov.core.compose.composeViewModel
import com.pisakov.createSessionScreen.CreateSessionScreen
import com.pisakov.createSessionScreen.di.CreateSessionScreenComponent
import com.pisakov.createSessionScreen.di.DaggerCreateSessionScreenComponent
import com.pisakov.favorite.FavoriteScreen
import com.pisakov.favorite.di.DaggerFavoriteScreenComponent
import com.pisakov.favorite.di.FavoriteScreenComponent
import com.pisakov.mainScreen.di.DaggerMainScreenComponent
import com.pisakov.mainScreen.di.MainScreenComponent
import com.pisakov.mainScreen.joinToSessionScreen.JoinToSessionScreen
import com.pisakov.mainScreen.mainScreen.MainScreen
import com.pisakov.navigation.ComposableModel
import com.pisakov.navigation.CreateSessionDestination
import com.pisakov.navigation.FavoriteScreenDestination
import com.pisakov.navigation.JoinToSessionDestination
import com.pisakov.navigation.MainScreenDestination
import com.pisakov.navigation.NavigationIntent
import com.pisakov.navigation.ProfileScreenDestination
import com.pisakov.navigation.SearchScreenDestination
import com.pisakov.profile.ProfileScreen
import com.pisakov.profile.di.DaggerProfileScreenComponent
import com.pisakov.profile.di.ProfileScreenComponent
import com.pisakov.search.SearchScreen
import com.pisakov.search.di.DaggerSearchScreenComponent
import com.pisakov.search.di.SearchScreenComponent
import kotlinx.coroutines.channels.Channel

@Composable
fun NavigationHost(
    modifier: Modifier,
    navigationChannel: Channel<NavigationIntent>,
    allModulesDependencies: AllModulesDependencies
) {

    val mainScreenComponent: MainScreenComponent by lazy(mode = LazyThreadSafetyMode.NONE) {
        DaggerMainScreenComponent.factory().create(allModulesDependencies.mainScreenDependencies)
    }

    val searchScreenComponent: SearchScreenComponent by lazy(mode = LazyThreadSafetyMode.NONE) {
        DaggerSearchScreenComponent.factory().create(allModulesDependencies.searchScreenDependencies)
    }

    val favoriteScreenComponent: FavoriteScreenComponent by lazy(mode = LazyThreadSafetyMode.NONE) {
        DaggerFavoriteScreenComponent.factory().create(allModulesDependencies.favoriteScreenDependencies)
    }

    val profileScreenComponent: ProfileScreenComponent by lazy(mode = LazyThreadSafetyMode.NONE) {
        DaggerProfileScreenComponent.factory().create(allModulesDependencies.profileScreenDependencies)
    }

    val createSearchScreenComponent: CreateSessionScreenComponent by lazy( mode = LazyThreadSafetyMode.NONE) {
        DaggerCreateSessionScreenComponent.factory().create(allModulesDependencies.createSessionScreenDependencies)
    }

    com.pisakov.navigation.NavigationHost(
        modifier = modifier,
        startDestination = MainScreenDestination.route,
        navigationChannel = navigationChannel,
        composableModels = listOf(
            ComposableModel(destination = MainScreenDestination.route) {
                MainScreen(composeViewModel { mainScreenComponent.getMainScreenViewModel() })
            },
            ComposableModel(destination = SearchScreenDestination.route) {
                SearchScreen(composeViewModel { searchScreenComponent.getSearchScreenViewModel() })
            },
            ComposableModel(destination = FavoriteScreenDestination.route) {
                FavoriteScreen(composeViewModel { favoriteScreenComponent.getFavoriteScreenViewModel() })
            },
            ComposableModel(destination = ProfileScreenDestination.route) {
                ProfileScreen(composeViewModel { profileScreenComponent.getProfileScreenViewModel() })
            },
            ComposableModel(destination = CreateSessionDestination.route) {
                CreateSessionScreen(
                    createSessionScreenViewModel = composeViewModel { createSearchScreenComponent.getCreateSessionViewModel() },
                    filtersScreenViewModel = composeViewModel { createSearchScreenComponent.getFiltersScreenViewModel() },
                    collectionsScreenViewModel = composeViewModel { createSearchScreenComponent.getCollectionsScreenViewModel() },
                )
            },
            ComposableModel(destination = JoinToSessionDestination.route) {
                JoinToSessionScreen(composeViewModel { mainScreenComponent.getJoinToSessionScreenViewModel() })
            }
        )
    )
}