package com.example.simplefirebasechat.presentation.ui.fragments.signInfragment


import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Toast
import androidx.annotation.StringRes
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.simplefirebasechat.R
import com.example.simplefirebasechat.presentation.base.BaseFragment
import com.example.simplefirebasechat.presentation.ui.activities.authactivity.SignInActivity
import com.example.simplefirebasechat.utils.afterTextChanged
import kotlin.reflect.KClass

class LoginFragment : BaseFragment<UserAuthViewModel>() {
    private lateinit var username: EditText
    private lateinit var password: EditText
    private lateinit var login: Button
    private lateinit var loading: ProgressBar

    private lateinit var loginViewModel: UserAuthViewModel

    override val fragmentResId: Int
        get() = R.layout.fragment_login

    override fun getViewModelClass(): KClass<UserAuthViewModel> {
        return UserAuthViewModel::class
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        performDI()
    }
    
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        username = view.findViewById(R.id.username)
        password = view.findViewById(R.id.password)
        login = view.findViewById(R.id.login)
        loading = view.findViewById(R.id.loading)
        populateViewModel()
        subscribesObservable()
        setViewListeners()
    }

    private fun subscribesObservable() {
        loginViewModel.loginFormState.observe(this, Observer {
            val loginState = it ?: return@Observer
            // disable login button unless both username / password is valid
            login.isEnabled = loginState.isDataValid

            if (loginState.usernameError != null) {
                username.error = getString(loginState.usernameError)
            }
            if (loginState.passwordError != null) {
                password.error = getString(loginState.passwordError)
            }
        })

        loginViewModel.loginResult.observe(this, Observer {
            val loginResult = it ?: return@Observer
            loading.visibility = View.GONE
            if (loginResult.error != null) {
                showLoginFailed(loginResult.error)
            }
            if (loginResult.success != null) {
                updateUiWithUser(loginResult.success)
            }
            //Complete and destroy login activity once successful
//            activity?.finish()
        })
    }

    private fun setViewListeners() {

        username.afterTextChanged {
            loginViewModel.loginDataChanged(
                username.text.toString(),
                password.text.toString()
            )
        }

        password.apply {
            afterTextChanged {
                loginViewModel.loginDataChanged(
                    username.text.toString(),
                    password.text.toString()
                )
            }

            setOnEditorActionListener { _, actionId, _ ->
                when (actionId) {
                    EditorInfo.IME_ACTION_DONE ->
                        loginViewModel.login(
                            username.text.toString(),
                            password.text.toString()
                        )
                }
                false
            }

            login.setOnClickListener {
                loading.visibility = View.VISIBLE
                loginViewModel.login(username.text.toString(), password.text.toString())
            }
        }
    }

    private fun populateViewModel() {
        loginViewModel =
            ViewModelProviders.of(this, viewModelFactory).get(UserAuthViewModel::class.java)
    }

    private fun performDI() {
        (activity as SignInActivity).authComponent.inject(this)
    }

    private fun updateUiWithUser(model: LoggedInUserView) {
        val welcome = getString(R.string.welcome)
        val displayName = model.displayName
        // TODO : initiate successful logged in experience
        Toast.makeText(
            activity,
            "$welcome $displayName",
            Toast.LENGTH_LONG
        ).show()
    }

    private fun showLoginFailed(@StringRes errorString: Int) {
        Toast.makeText(activity, errorString, Toast.LENGTH_SHORT).show()
    }

}
