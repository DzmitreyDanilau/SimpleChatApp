package com.example.simplefirebasechat.di.modules

import com.example.simplefirebasechat.di.components.SignInComponent
import dagger.Module
import javax.inject.Singleton

@Singleton
@Module(subcomponents = [SignInComponent::class])
class AppSubComponents
