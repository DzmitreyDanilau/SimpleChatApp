package com.example.simplefirebasechat.presentation.ui.fragments.emailloginfragment

import android.util.Patterns
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.simplefirebasechat.R
import com.example.simplefirebasechat.domain.authinteractor.IAuthInteractor
import com.example.simplefirebasechat.presentation.base.BaseViewModel
import com.example.simplefirebasechat.utils.addTo
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class EmailLoginViewModel @Inject constructor(private val authInteractor: IAuthInteractor) :
    BaseViewModel() {

    override val compositeDisposable: CompositeDisposable
        get() = CompositeDisposable()

    private val _loginForm = MutableLiveData<LoginFormState>()
    val loginFormState: LiveData<LoginFormState> = _loginForm

    private val _loginResult = MutableLiveData<LoginResult>()
    val loginResult: LiveData<LoginResult> = _loginResult

    fun login(username: String, password: String) {
        authInteractor.login(username, password)
            .observeOn(Schedulers.io())
            .subscribe(
                {
                    _loginResult.postValue(LoginResult(success = LoggedInUserView(username)))
                },
                {
                    _loginResult.postValue(LoginResult(error = R.string.login_failed))
                }
            ) addTo CompositeDisposable()
    }
    fun loginDataChanged(username: String, password: String) {
        if (!isUserNameValid(username)) {
            _loginForm.value =
                LoginFormState(usernameError = R.string.invalid_username)
        } else if (!isPasswordValid(password)) {
            _loginForm.value =
                LoginFormState(passwordError = R.string.invalid_password)
        } else {
            _loginForm.value = LoginFormState(isDataValid = true)
        }
    }

    // A placeholder username validation check
    private fun isUserNameValid(username: String): Boolean {
        return if (username.contains('@')) {
            Patterns.EMAIL_ADDRESS.matcher(username).matches()
        } else {
            username.isNotBlank()
        }
    }

    // A placeholder password validation check
    private fun isPasswordValid(password: String): Boolean {
        return password.length > 5
    }

}