package com.example.simplefirebasechat.data.firebase.firebaseauth

import com.example.simplefirebasechat.data.model.LoggedInUser
import io.reactivex.Completable
import io.reactivex.Single

interface IFirebaseAuth {
    fun login(email: String, password: String): Single<LoggedInUser>
    fun register(email: String, password: String): Completable
    fun logout(): Completable
}