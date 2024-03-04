package com.pisakov.cinemate

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.pisakov.auth.GoogleAuth
import com.pisakov.cinemate.containerScreen.ContainerScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { ContainerScreen() }
        signIn()
    }

    private fun signIn() {
        GoogleAuth.signIn(this, activityResultRegistry, getString(R.string.default_web_client_id)) {
            println("!!!!!!!!!!! fail")
        }
    }
}