package com.example.simplefirebasechat.di.components

import android.content.Context
import com.example.simplefirebasechat.di.modules.*
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules =
    [
        AppSubComponents::class,
        AppModule::class,
        AppViewModelsModule::class,
        AppInteractorsModule::class,
        AppRepositoriesModule::class
    ]
)
interface AppComponent {

    fun registerAuthComponent(): AuthComponent.Factory

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): AppComponent
    }
}