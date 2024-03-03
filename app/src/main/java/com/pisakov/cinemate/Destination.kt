package com.pisakov.cinemate

import com.pisakov.favorite.FavoriteDependencies

sealed class Destination(val route: String, vararg params: String) {
    val fullRoute: String = if (params.isEmpty()) route else {
        val builder = StringBuilder(route)
        params.forEach { builder.append("/{${it}}") }
        builder.toString()
    }

    sealed class NoArgumentsDestination(route: String) : Destination(route) {
        operator fun invoke(): String = route
    }

    object MainScreen : NoArgumentsDestination("main")

    object SearchScreen : NoArgumentsDestination("search")

    object FavoriteScreen : Destination("favorite", "favoriteDependencies") {
        const val FAVORITE_DESTINATION = "favoriteDependencies"

        operator fun invoke(favoriteDependencies: FavoriteDependencies): String = route.appendParams(
            FAVORITE_DESTINATION to favoriteDependencies
        )
    }

    object ProfileScreen : NoArgumentsDestination("profile")
}

internal fun String.appendParams(vararg params: Pair<String, Any?>): String {
    val builder = StringBuilder(this)

    params.forEach {
        it.second?.toString()?.let { arg ->
            builder.append("/$arg")
        }
    }

    return builder.toString()
}