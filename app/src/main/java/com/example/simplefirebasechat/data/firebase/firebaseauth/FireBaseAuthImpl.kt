package com.example.simplefirebasechat.data.firebase.firebaseauth

import com.example.simplefirebasechat.data.model.LoggedInUser
import com.example.simplefirebasechat.data.storages.Storage
import com.google.firebase.auth.FirebaseAuth
import io.reactivex.Completable
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class FireBaseAuthImpl @Inject constructor() : IFirebaseAuth, Storage {

    private val firebaseAuth: FirebaseAuth = FirebaseAuth.getInstance()


    override fun login(email: String, password: String): Single<LoggedInUser> {
        return Single.create {
            firebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener {
                if (it.isSuccessful) {
                    val isNewUser = it.result?.additionalUserInfo?.isNewUser
                    firebaseAuth.currentUser?.let { user ->
                        LoggedInUser("", user.displayName!!, user.uid, user.email!!, isNewUser!!)
                    }
                }
            }
        }
    }

    override fun register(email: String, password: String) = Completable.create { emitter ->
        firebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener {
            if (!emitter.isDisposed) {
                if (it.isSuccessful)
                    emitter.onComplete()
                else
                    emitter.onError(it.exception!!)
            }
        }
    }.subscribeOn(Schedulers.io())

    override fun logout() = Completable.create {
        firebaseAuth.signOut()
    }.subscribeOn(Schedulers.io())
}
