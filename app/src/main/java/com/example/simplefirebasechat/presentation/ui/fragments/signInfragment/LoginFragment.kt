package com.example.simplefirebasechat.presentation.ui.fragments.signInfragment


import com.example.simplefirebasechat.R
import com.example.simplefirebasechat.presentation.base.BaseFragment
import kotlin.reflect.KClass

class SignInFragment : BaseFragment<UserAuthViewModel>() {
    override val fragmentResId: Int
        get() = R.layout.fragment_login

    override fun getViewModelClass(): KClass<UserAuthViewModel> {
        return UserAuthViewModel::class
    }
}
