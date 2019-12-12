package com.example.simplefirebasechat.data.repositories.authrepository

import com.example.simplefirebasechat.data.storages.remote.FireBaseAuthImpl
import com.example.simplefirebasechat.data.storages.remote.IFirebaseAuth
import com.google.firebase.auth.FirebaseAuth
import io.reactivex.Completable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(val firebaseSource: FireBaseAuthImpl) :
    IUserRepository {

    override fun login(email: String, password: String): Completable {
        return firebaseSource.login(email, password)
    }

    override fun register(email: String, password: String): Completable {
        return firebaseSource.register(email, password)
    }

    override fun logout(): Completable {
        return firebaseSource.logout()
    }
}

