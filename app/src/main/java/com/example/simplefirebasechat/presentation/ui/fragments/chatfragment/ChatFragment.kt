package com.example.simplefirebasechat.presentation.ui.fragments.chatfragment


import android.os.Bundle
import android.view.View
import com.example.simplefirebasechat.R
import com.example.simplefirebasechat.presentation.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_chat.*
import kotlin.reflect.KClass

class ChatFragment : BaseFragment<ChatFragmentViewModel>() {

    override val fragmentResId: Int
        get() = R.layout.fragment_chat

    override fun getViewModelClass(): KClass<ChatFragmentViewModel> {
        return ChatFragmentViewModel::class
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()
        initClicks()
    }

    private fun initRecyclerView() {
        message_recycler_view.adapter
    }

    private fun initClicks() {
        btn_send.setOnClickListener {

        }
    }
}

