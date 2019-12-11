package com.example.simplefirebasechat.presentation.base

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject
import kotlin.reflect.KClass

abstract class BaseFragment<V : BaseViewModel> : Fragment() {

    @get:LayoutRes
    abstract val fragmentResId: Int

    @Inject
    protected lateinit var viewModelFactory: ViewModelProvider.Factory
    protected lateinit var viewModel: V
    protected abstract fun getViewModelClass(): KClass<V>


    override fun onAttach(context: Context) {
        super.onAttach(context)
        performDi()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(fragmentResId, container, false)
    }

    private fun performDi(){

    }
}