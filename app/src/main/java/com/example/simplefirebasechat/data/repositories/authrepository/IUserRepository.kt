package com.example.simplefirebasechat.data.repositories.authrepository

import io.reactivex.Completable

interface IUserRepository {
    fun login(email: String, password: String): Completable
    fun register(email: String, password: String): Completable
    fun logout(): Completable
}