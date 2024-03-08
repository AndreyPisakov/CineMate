package com.pisakov.cinemate.containerScreen

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import com.pisakov.cinemate.di.AllModulesDependencies
import com.pisakov.favorite.DaggerFavoriteScreenComponent
import com.pisakov.favorite.FavoriteScreen
import com.pisakov.favorite.FavoriteScreenComponent
import com.pisakov.main_screen.createSessionScreen.CreateSessionScreen
import com.pisakov.main_screen.di.DaggerMainScreenComponent
import com.pisakov.main_screen.di.MainScreenComponent
import com.pisakov.main_screen.joinToSessionScreen.JoinToSessionScreen
import com.pisakov.main_screen.mainScreen.MainScreen
import com.pisakov.navigation.ComposableModel
import com.pisakov.navigation.CreateSessionDestination
import com.pisakov.navigation.FavoriteScreenDestination
import com.pisakov.navigation.JoinToSessionDestination
import com.pisakov.navigation.MainScreenDestination
import com.pisakov.navigation.NavigationIntent
import com.pisakov.navigation.ProfileScreenDestination
import com.pisakov.navigation.SearchScreenDestination
import com.pisakov.profile.DaggerProfileScreenComponent
import com.pisakov.profile.ProfileScreen
import com.pisakov.profile.ProfileScreenComponent
import com.pisakov.search.DaggerSearchScreenComponent
import com.pisakov.search.SearchScreen
import com.pisakov.search.SearchScreenComponent
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

    com.pisakov.navigation.NavigationHost(
        modifier = modifier,
        startDestination = MainScreenDestination.route,
        navigationChannel = navigationChannel,
        composableModels = listOf(
            ComposableModel(destination = MainScreenDestination.route) {
                MainScreen(daggerViewModel { mainScreenComponent.getMainScreenViewModel() })
            },
            ComposableModel(destination = SearchScreenDestination.route) {
                SearchScreen(daggerViewModel { searchScreenComponent.getSearchScreenViewModel() })
            },
            ComposableModel(destination = FavoriteScreenDestination.route) {
                FavoriteScreen(daggerViewModel { favoriteScreenComponent.getFavoriteScreenViewModel() })
            },
            ComposableModel(destination = ProfileScreenDestination.route) {
                ProfileScreen(daggerViewModel { profileScreenComponent.getProfileScreenViewModel() })
            },
            ComposableModel(destination = CreateSessionDestination.route) {
                CreateSessionScreen(daggerViewModel { mainScreenComponent.getCreateSessionViewModel() })
            },
            ComposableModel(destination = JoinToSessionDestination.route) {
                JoinToSessionScreen(daggerViewModel { mainScreenComponent.getJoinToSessionScreenViewModel() })
            }
        )
    )
}

@Composable
inline fun <reified T : ViewModel> daggerViewModel(
    key: String? = null,
    crossinline viewModelInstanceCreator: () -> T
): T =
    viewModel(
        modelClass = T::class.java,
        key = key,
        factory = object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return viewModelInstanceCreator() as T
            }
        }
    )