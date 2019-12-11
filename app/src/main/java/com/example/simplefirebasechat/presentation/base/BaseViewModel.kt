package com.example.simplefirebasechat.presentation.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

abstract class BaseViewModel : ViewModel() {

    private val _error = MutableLiveData<String>()
    val error: LiveData<String?>
        get() = _error

}