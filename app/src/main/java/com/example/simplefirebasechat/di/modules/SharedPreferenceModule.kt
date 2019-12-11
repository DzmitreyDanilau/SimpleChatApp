package com.example.simplefirebasechat.di.modules

import android.content.Context
import android.content.SharedPreferences
import com.example.simplefirebasechat.utils.SHARED_PREFERENCES
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Singleton
@Module
class SharedPreferenceModule {
    @Provides
    fun provideSharedPreference(context: Context): SharedPreferences {
        return context.getSharedPreferences(SHARED_PREFERENCES, Context.MODE_PRIVATE)
    }
}
