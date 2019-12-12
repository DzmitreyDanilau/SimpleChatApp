package com.example.simplefirebasechat.di.modules

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.simplefirebasechat.di.scopes.ViewModelKey
import com.example.simplefirebasechat.presentation.ui.activities.authactivity.SignInActivityViewModel
import com.example.simplefirebasechat.presentation.ui.fragments.signInfragment.UserAuthViewModel
import com.example.simplefirebasechat.utils.ViewModelFactory
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface AppViewModelsModule {
    @Binds
    fun provideViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(UserAuthViewModel::class)
    fun provideUserAuthViewModel(viewModel: UserAuthViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(SignInActivityViewModel::class)
    fun provideSignInActivityViewModel(viewModel: SignInActivityViewModel): ViewModel
}