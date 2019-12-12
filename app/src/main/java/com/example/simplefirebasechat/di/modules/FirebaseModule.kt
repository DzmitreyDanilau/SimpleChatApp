package com.example.simplefirebasechat.di.modules

import com.example.simplefirebasechat.data.storages.remote.FireBaseAuthImpl
import dagger.Module
import dagger.Provides


@Module
class FirebaseModule {
    @Provides
    fun provideFirebaseAuthImpl(): FireBaseAuthImpl {
        return FireBaseAuthImpl()
    }
}