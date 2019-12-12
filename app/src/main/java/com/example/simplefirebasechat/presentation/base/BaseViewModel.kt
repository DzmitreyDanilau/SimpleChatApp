package com.example.simplefirebasechat.presentation.base

import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable

abstract class BaseViewModel : ViewModel() {

    abstract val compositeDisposable: CompositeDisposable
    lateinit var binding: DataBindingUtil

    private val _error = MutableLiveData<String>()
    val error: LiveData<String?>
        get() = _error



    override fun onCleared() {
        compositeDisposable.dispose()
        super.onCleared()
    }
}