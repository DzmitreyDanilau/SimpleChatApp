package com.example.simplefirebasechat.di.components

import android.content.Context
import com.example.simplefirebasechat.di.modules.AppModule
import com.example.simplefirebasechat.di.modules.AppSubComponents
import com.example.simplefirebasechat.di.modules.AppViewModelModule
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules =
    [
        AppSubComponents::class,
        AppModule::class,
        AppViewModelModule::class
    ]
)
interface AppComponent {
    fun registerSignInComponent(): SignInComponent.Factory
    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): AppComponent
    }
}