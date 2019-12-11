package com.example.simplefirebasechat.data.repositories.authrepository

import com.example.simplefirebasechat.data.remotestorages.IFirebaseSource
import io.reactivex.Completable
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(private val firebaseSource: IFirebaseSource) :
    IUserRepository {

    override fun login(email: String, password: String): Completable {
        return firebaseSource.login(email, password)
    }

    override fun register(email: String, password: String): Completable {
        return firebaseSource.register(email, password)
    }

    override fun logout() {
        return firebaseSource.logout()
    }
}

