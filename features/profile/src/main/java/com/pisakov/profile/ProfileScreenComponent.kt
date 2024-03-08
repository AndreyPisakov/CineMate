package com.pisakov.profile

import com.pisakov.navigation.screenDependencies.ProfileScreenDependencies
import dagger.Component
import javax.inject.Singleton

@Component(dependencies = [ProfileScreenDependencies::class])
@Singleton
interface ProfileScreenComponent {

    fun getProfileScreenViewModel(): ProfileScreenViewModel

    @Component.Factory
    interface Factory {

        fun create(
            profileScreenDependencies: ProfileScreenDependencies
        ): ProfileScreenComponent
    }
}