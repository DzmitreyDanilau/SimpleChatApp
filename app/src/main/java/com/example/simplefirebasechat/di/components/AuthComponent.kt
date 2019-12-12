package com.example.simplefirebasechat.di.components

import com.example.simplefirebasechat.di.modules.FirebaseModule
import com.example.simplefirebasechat.di.scopes.ActivityScope
import com.example.simplefirebasechat.presentation.ui.activities.authactivity.SignInActivity
import com.example.simplefirebasechat.presentation.ui.fragments.signInfragment.LoginFragment
import com.example.simplefirebasechat.presentation.ui.fragments.signInfragment.RegistrationFragment
import dagger.Subcomponent

@ActivityScope
@Subcomponent(modules = [FirebaseModule::class])
interface AuthComponent {

    fun inject(activity: SignInActivity)
    fun inject(fragment: LoginFragment)
    fun inject(fragment: RegistrationFragment)

    @Subcomponent.Factory
    interface Factory {
        fun create(): AuthComponent
    }
}