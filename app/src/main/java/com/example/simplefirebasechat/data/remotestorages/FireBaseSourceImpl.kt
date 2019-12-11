package com.example.simplefirebasechat.data.remotestorages

import com.google.firebase.auth.FirebaseAuth
import io.reactivex.Completable
import javax.inject.Inject

class FireBaseSourceImpl @Inject constructor(private val firebaseAuthInstance: FirebaseAuth) :
    IFirebaseSource {


    override fun login(email: String, password: String) = Completable.create { emitter ->
        firebaseAuthInstance.signInWithEmailAndPassword(email, password).addOnCompleteListener {
            if (!emitter.isDisposed) {
                if (it.isSuccessful)
                    emitter.onComplete()
                else
                    emitter.onError(it.exception!!)
            }
        }
    }

    override fun register(email: String, password: String) = Completable.create { emitter ->
        firebaseAuthInstance.createUserWithEmailAndPassword(email, password).addOnCompleteListener {
            if (!emitter.isDisposed) {
                if (it.isSuccessful)
                    emitter.onComplete()
                else
                    emitter.onError(it.exception!!)
            }
        }
    }

    override fun logout() = firebaseAuthInstance.signOut()
}