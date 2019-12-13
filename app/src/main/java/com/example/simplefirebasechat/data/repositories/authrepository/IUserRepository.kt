package com.example.simplefirebasechat.data.repositories.authrepository

import com.example.simplefirebasechat.data.model.LoggedInUser
import io.reactivex.Completable
import io.reactivex.Single

interface IUserRepository {
    fun login(email: String, password: String): Single<LoggedInUser>
    fun register(email: String, password: String): Completable
    fun logout(): Completable
}