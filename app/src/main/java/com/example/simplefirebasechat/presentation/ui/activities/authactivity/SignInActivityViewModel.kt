package com.example.simplefirebasechat.presentation.ui.activities.authactivity

import com.example.simplefirebasechat.presentation.base.BaseViewModel
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class SignInActivityViewModel @Inject constructor() : BaseViewModel() {
    override val compositeDisposable: CompositeDisposable
        get() = CompositeDisposable()
}