package com.example.simplefirebasechat.domain.authinteractor

import io.reactivex.Completable

interface IAuthInteractor {
    fun login(email: String, password: String): Completable
    fun register(email: String, password: String) : Completable
    fun logout()
}