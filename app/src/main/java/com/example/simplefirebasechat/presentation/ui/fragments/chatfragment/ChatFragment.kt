package com.example.simplefirebasechat.presentation.ui.fragments.chatfragment


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.simplefirebasechat.R
import kotlinx.android.synthetic.main.fragment_chat.*

class ChatFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_chat, container, false)
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

