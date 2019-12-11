package com.example.simplefirebasechat

import android.app.Application
import com.example.simplefirebasechat.di.components.AppComponent
import com.example.simplefirebasechat.di.components.DaggerAppComponent
import timber.log.Timber

open class SimpleChatApp : Application() {

    val appComponent: AppComponent by lazy {
        initComponent()
    }

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
    }
    open fun initComponent() : AppComponent{
        return DaggerAppComponent.factory().create(applicationContext)
    }
}