package com.pisakov.auth

import com.google.firebase.auth.FirebaseAuth
import javax.inject.Inject

class GetUserRepository @Inject constructor(
    private val firebaseAuth: FirebaseAuth
) {

    fun invoke(): User {
        val user = firebaseAuth.currentUser ?: throw NoCurrentUserException()
        return User(
            name = user.displayName,
            photoUrl = user.photoUrl.toString(),
            uid = user.uid
        )
    }
}

data class User(
    val name: String?,
    val photoUrl: String?,
    val uid: String
)

class NoCurrentUserException : Exception()