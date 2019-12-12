package com.example.simplefirebasechat.presentation.ui.activities.authactivity

import android.os.Bundle
import android.view.View
import com.example.simplefirebasechat.R
import com.example.simplefirebasechat.SimpleChatApp
import com.example.simplefirebasechat.di.components.AuthComponent
import com.example.simplefirebasechat.presentation.base.BaseActivity
import kotlin.reflect.KClass


class SignInActivity : BaseActivity<SignInActivityViewModel>() {
    lateinit var authComponent: AuthComponent

    override val layoutResId: Int
        get() = R.layout.activity_sign_in

    override fun getViewModelClass(): KClass<SignInActivityViewModel> {
        return SignInActivityViewModel::class
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        performDI()
        super.onCreate(savedInstanceState)
    }

    private fun performDI() {
        authComponent =
            (application as SimpleChatApp).appComponent.registerAuthComponent().create()
        authComponent.inject(this)
    }

    companion object {
        private const val TAG = "SignInActivity"
        private const val RC_SIGN_IN = 9001
    }
}