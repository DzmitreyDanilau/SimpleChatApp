package com.example.simplefirebasechat.data.repositories.authrepository

import com.example.simplefirebasechat.data.firebase.firebaseauth.FireBaseAuthImpl
import com.example.simplefirebasechat.data.model.LoggedInUser
import io.reactivex.Completable
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(val firebaseAuth: FireBaseAuthImpl) :
    IUserRepository {

    override fun login(email: String, password: String): Single<LoggedInUser> {
        return firebaseAuth.login(email, password)
            .subscribeOn(Schedulers.io())
    }

    override fun register(email: String, password: String): Completable {
        return firebaseAuth.register(email, password)
    }

    override fun logout(): Completable {
        return firebaseAuth.logout()
    }
}

