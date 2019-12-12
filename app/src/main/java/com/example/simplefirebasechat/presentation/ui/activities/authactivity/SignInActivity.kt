package com.example.simplefirebasechat.presentation.ui.activities.authactivity

import android.os.Bundle
import android.view.View
import com.example.simplefirebasechat.R
import com.example.simplefirebasechat.SimpleChatApp
import com.example.simplefirebasechat.di.components.AuthComponent
import com.example.simplefirebasechat.presentation.base.BaseActivity
import kotlin.reflect.KClass


class SignInActivity : BaseActivity<SignInActivityViewModel>(),
    View.OnClickListener {
    lateinit var signInComponent: AuthComponent

    override val layoutResId: Int
        get() = R.layout.activity_sign_in

    override fun getViewModelClass(): KClass<SignInActivityViewModel> {
        return SignInActivityViewModel::class
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        performDI()
        super.onCreate(savedInstanceState)
    }

    override fun onClick(v: View?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private fun performDI() {
        signInComponent =
            (application as SimpleChatApp).appComponent.registerAuthComponent().create()
        signInComponent.inject(this)
    }

    companion object {
        private const val TAG = "SignInActivity"
        private const val RC_SIGN_IN = 9001
    }
}