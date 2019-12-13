package com.example.simplefirebasechat.di.components

import com.example.simplefirebasechat.di.modules.FirebaseModule
import com.example.simplefirebasechat.di.scopes.ActivityScope
import com.example.simplefirebasechat.presentation.ui.activities.authactivity.SignInActivity
import com.example.simplefirebasechat.presentation.ui.fragments.emailloginfragment.EmailLoginFragment
import com.example.simplefirebasechat.presentation.ui.fragments.registrationfragment.RegistrationFragment
import dagger.Subcomponent

@ActivityScope
@Subcomponent(modules = [FirebaseModule::class])
interface AuthComponent {

    fun inject(activity: SignInActivity)
    fun inject(fragment: EmailLoginFragment)
    fun inject(fragment: RegistrationFragment)

    @Subcomponent.Factory
    interface Factory {
        fun create(): AuthComponent
    }
}