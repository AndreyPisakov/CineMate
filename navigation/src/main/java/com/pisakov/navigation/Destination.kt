package com.pisakov.navigation

sealed class Destination(val route: String) {
    operator fun invoke(): String = route
}

