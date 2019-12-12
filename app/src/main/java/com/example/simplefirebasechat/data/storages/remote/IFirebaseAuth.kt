package com.example.simplefirebasechat.data.storages.remote

import io.reactivex.Completable
import io.reactivex.Single

interface IFirebaseAuth {
    fun login(email: String, password: String): Completable
    fun register(email: String, password: String): Completable
    fun logout(): Completable
}