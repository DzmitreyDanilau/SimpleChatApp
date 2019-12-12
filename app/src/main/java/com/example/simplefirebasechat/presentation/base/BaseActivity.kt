package com.example.simplefirebasechat.presentation.base

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import timber.log.Timber
import javax.inject.Inject
import kotlin.reflect.KClass

abstract class BaseActivity<V : BaseViewModel> : AppCompatActivity() {

    @get:LayoutRes
    abstract val layoutResId: Int

    @Inject
    protected lateinit var viewModelFactory: ViewModelProvider.Factory
    protected lateinit var viewModel: V

    protected abstract fun getViewModelClass(): KClass<V>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutResId)
        initViewModel()
        Timber.d("onCreate %s", this.toString())
    }

    private fun initViewModel() {
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(getViewModelClass().java)
    }
}