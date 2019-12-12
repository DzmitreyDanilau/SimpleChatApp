package com.example.simplefirebasechat.presentation.ui.fragments.signInfragment

interface AuthListener {
    fun onStarted()
    fun onSuccess()
    fun onFailure(massage: String)
}