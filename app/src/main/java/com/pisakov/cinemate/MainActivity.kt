package com.pisakov.cinemate

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.pisakov.auth.GoogleAuth
import com.pisakov.cinemate.containerScreen.ContainerScreen
import com.pisakov.cinemate.containerScreen.daggerViewModel
import com.pisakov.cinemate.di.AllModulesDependencies
import com.pisakov.cinemate.di.DaggerAppComponent
import com.pisakov.data.di.DaggerDataComponent
import javax.inject.Inject

class MainActivity : ComponentActivity() {

    @Inject
    lateinit var allModulesDependencies: AllModulesDependencies

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val dataComponent = DaggerDataComponent.factory().create()
        val appComponent = DaggerAppComponent.factory().create(dataComponent.provideRepositories()).apply {
            inject(this@MainActivity)
        }
        setContent {
            ContainerScreen(
                allModulesDependencies,
                daggerViewModel { appComponent.getContainerScreenViewModel() }
            )
        }
        signIn()
    }

    private fun signIn() {
        GoogleAuth.signIn(this, activityResultRegistry, getString(R.string.default_web_client_id)) {
            println("!!!!!!!!!!! fail")
        }
    }
}