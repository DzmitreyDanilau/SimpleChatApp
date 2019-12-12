package com.example.simplefirebasechat.di.components

import com.example.simplefirebasechat.di.scopes.ActivityScope
import com.example.simplefirebasechat.presentation.ui.fragments.signInfragment.LoginFragment
import dagger.Subcomponent

@ActivityScope
@Subcomponent
interface SignInComponent {

    fun inject(fragment: LoginFragment)

    @Subcomponent.Factory
    interface Factory {
        fun create(): SignInComponent
    }
}