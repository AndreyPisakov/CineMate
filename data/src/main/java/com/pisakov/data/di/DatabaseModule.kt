package com.pisakov.data.di

import com.google.firebase.database.FirebaseDatabase
import dagger.Module
import dagger.Provides

@Module
class DatabaseModule {

    @Provides
    @DataScope
    fun provideFirebaseDatabase(): FirebaseDatabase = FirebaseDatabase.getInstance()
}