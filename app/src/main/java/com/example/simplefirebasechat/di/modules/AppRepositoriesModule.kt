package com.example.simplefirebasechat.di.modules

import com.example.simplefirebasechat.data.repositories.authrepository.IUserRepository
import com.example.simplefirebasechat.data.repositories.authrepository.UserRepositoryImpl
import dagger.Binds
import dagger.Module

@Module
interface AppRepositoriesModule {

    @Binds
    fun provideUserRepositories(userRepositoryImpl: UserRepositoryImpl): IUserRepository
}