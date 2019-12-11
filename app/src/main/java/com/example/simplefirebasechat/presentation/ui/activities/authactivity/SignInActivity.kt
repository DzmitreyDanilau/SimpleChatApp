package com.example.simplefirebasechat.presentation.ui.activities.authactivity

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.simplefirebasechat.R
import com.example.simplefirebasechat.presentation.base.BaseActivity
import com.google.android.gms.auth.api.Auth
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.ConnectionResult
import com.google.android.gms.common.SignInButton
import com.google.android.gms.common.api.GoogleApiClient
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener
import timber.log.Timber
import kotlin.reflect.KClass


class SignInActivity : BaseActivity<SignIntActivityViewModel>(), OnConnectionFailedListener,
    View.OnClickListener {


    override fun onConnectionFailed(connectionResult: ConnectionResult) {
        Timber.d("onConnectionFailed:$connectionResult")
        Toast.makeText(this, "Google Play Services error.", Toast.LENGTH_SHORT).show()
    }


    override val layoutResId: Int
        get() = R.layout.activity_sign_in

    override fun getViewModelClass(): KClass<SignIntActivityViewModel> {
        return SignIntActivityViewModel::class
    }

    override fun onClick(v: View?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    companion object {
        private const val TAG = "SignInActivity"
        private const val RC_SIGN_IN = 9001
    }
}