package com.example.simplefirebasechat.di.components

import android.content.Context
import android.content.SharedPreferences
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component
interface AppComponent {
    fun registerSignInComponent(): SignInComponent
    fun inject(): SharedPreferences
    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): AppComponent
    }
}