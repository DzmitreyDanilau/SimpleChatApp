package com.example.simplefirebasechat.data.firebase.firebaseauth

import io.reactivex.Completable

interface IFirebaseAuth {
    fun login(email: String, password: String): Completable
    fun register(email: String, password: String): Completable
    fun logout(): Completable
}