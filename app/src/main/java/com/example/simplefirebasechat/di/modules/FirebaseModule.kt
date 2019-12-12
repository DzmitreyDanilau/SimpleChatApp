package com.example.simplefirebasechat.di.modules

import com.google.firebase.auth.FirebaseAuth
import dagger.Module
import dagger.Provides


@Module
class FirebaseModule {
    @Provides
    fun provideFirebaseAtuhInstance(): FirebaseAuth {
        return FirebaseAuth.getInstance()
    }
}