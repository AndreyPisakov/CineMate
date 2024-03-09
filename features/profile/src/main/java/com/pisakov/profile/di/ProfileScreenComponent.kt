package com.pisakov.profile.di

import com.pisakov.profile.ProfileScreenViewModel
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