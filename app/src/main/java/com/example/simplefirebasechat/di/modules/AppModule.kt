package com.example.simplefirebasechat.di.modules

import android.content.Context
import android.content.SharedPreferences
import com.example.simplefirebasechat.utils.SHARED_PREFERENCES
import dagger.Module
import dagger.Provides

@Module
class AppModule {
    @Provides
    fun provideSharedPreference(context: Context): SharedPreferences {
        return context.getSharedPreferences(SHARED_PREFERENCES, Context.MODE_PRIVATE)
    }
}