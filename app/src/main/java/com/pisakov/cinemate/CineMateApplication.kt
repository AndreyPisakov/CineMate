package com.pisakov.cinemate

import android.app.Application
import com.google.firebase.FirebaseApp
import com.pisakov.data.BuildConfig
import timber.log.Timber

class CineMateApplication : Application() {

    override fun onCreate(){
        super.onCreate()
        FirebaseApp.initializeApp(applicationContext)
        if(BuildConfig.DEBUG){
            Timber.plant(Timber.DebugTree())
        }
    }
}