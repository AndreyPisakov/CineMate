package com.pisakov.cinemate.di

import com.google.firebase.database.FirebaseDatabase
import com.pisakov.data.repository.SessionRepositoryImpl
import com.pisakov.domain.repository.SessionRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface DataModule {

    @Binds
    fun bindSessionRepository(impl: SessionRepositoryImpl): SessionRepository

    companion object {
        @Provides
        fun provideFirebaseDatabase() = FirebaseDatabase.getInstance()
    }
}