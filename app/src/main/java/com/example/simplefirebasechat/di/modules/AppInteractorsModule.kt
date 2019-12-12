package com.example.simplefirebasechat.di.modules

import com.example.simplefirebasechat.domain.authinteractor.AuthInteractorImpl
import com.example.simplefirebasechat.domain.authinteractor.IAuthInteractor
import dagger.Binds
import dagger.Module

@Module
interface AppInteractorsModule {
    @Binds
    fun provideAuthInteractor(authInteractorImpl: AuthInteractorImpl): IAuthInteractor
}