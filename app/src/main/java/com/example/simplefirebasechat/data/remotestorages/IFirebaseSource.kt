package com.example.simplefirebasechat.data.remotestorages

import io.reactivex.Completable

interface IFirebaseSource {
    fun login(email: String, password: String): Completable
    fun register(email: String, password: String) : Completable
    fun logout()
}