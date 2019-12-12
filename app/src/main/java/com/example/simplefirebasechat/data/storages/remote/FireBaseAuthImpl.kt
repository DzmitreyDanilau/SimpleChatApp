package com.example.simplefirebasechat.data.storages.remote

import com.example.simplefirebasechat.data.storages.Storage
import com.google.firebase.auth.FirebaseAuth
import io.reactivex.Completable
import io.reactivex.Scheduler
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class FireBaseAuthImpl @Inject constructor(private val firebaseAuthInstance: FirebaseAuth) :
    IFirebaseAuth, Storage {


    override fun login(email: String, password: String) = Completable.create { emitter ->
        firebaseAuthInstance.signInWithEmailAndPassword(email, password).addOnCompleteListener {
            if (!emitter.isDisposed) {
                if (it.isSuccessful)
                    emitter.onComplete()
                else
                    emitter.onError(it.exception!!)
            }
        }
    }.subscribeOn(Schedulers.io())

    override fun register(email: String, password: String) = Completable.create { emitter ->
        firebaseAuthInstance.createUserWithEmailAndPassword(email, password).addOnCompleteListener {
            if (!emitter.isDisposed) {
                if (it.isSuccessful)
                    emitter.onComplete()
                else
                    emitter.onError(it.exception!!)
            }
        }
    }.subscribeOn(Schedulers.io())

    override fun logout() = Completable.create {
        firebaseAuthInstance.signOut()
    }.subscribeOn(Schedulers.io())
}