package com.pisakov.auth

import android.app.Activity
import androidx.activity.result.ActivityResultRegistry
import androidx.activity.result.contract.ActivityResultContracts
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.firebase.auth.GoogleAuthProvider
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

object GoogleAuth {

    private const val ACTIVITY_RESULT_KEY = "GOOGLE_SIGN_IN_KEY"

    fun signIn(
        activity: Activity,
        activityResultRegistry: ActivityResultRegistry,
        defaultWebClientId: String,
        onFailure: () -> Unit
    ) {
        activityResultRegistry.register(ACTIVITY_RESULT_KEY, ActivityResultContracts.StartActivityForResult()) {
            val task = GoogleSignIn.getSignedInAccountFromIntent(it.data)
            runCatching {
                val account = task.getResult(ApiException::class.java)
                account.idToken?.let { idToken ->
                    val auth = Firebase.auth
                    val credential = GoogleAuthProvider.getCredential(idToken, null)
                    auth.signInWithCredential(credential).addOnCompleteListener { authResultTask ->
                        if (!authResultTask.isSuccessful) onFailure()
                    }
                }
            }
                .onFailure { onFailure() }
        }.launch(
            GoogleSignIn.getClient(
                activity,
                getGoogleSignInOptions(defaultWebClientId)
            ).signInIntent
        )
    }

    private fun getGoogleSignInOptions(defaultWebClientId: String): GoogleSignInOptions {
        return GoogleSignInOptions
            .Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(defaultWebClientId)
            .requestEmail()
            .build()
    }
}