package com.example.simplefirebasechat.di.components

import com.example.simplefirebasechat.di.scopes.ActivityScope
import com.example.simplefirebasechat.presentation.ui.fragments.signInfragment.SignInFragment
import dagger.Subcomponent

@ActivityScope
@Subcomponent
interface SignInComponent {

    fun inject(fragment: SignInFragment)

    @Subcomponent.Factory
    interface Factory {
        fun create(): SignInComponent
    }
}