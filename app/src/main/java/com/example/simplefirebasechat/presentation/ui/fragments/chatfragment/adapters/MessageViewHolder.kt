package com.example.simplefirebasechat.presentation.ui.fragments.chatfragment.adapters

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.simplefirebasechat.R
import de.hdodenhof.circleimageview.CircleImageView

class MessageViewHolder(v: View?) : RecyclerView.ViewHolder(v!!) {
    var messageTextView: TextView
    var messageImageView: ImageView
    var messengerTextView: TextView
    var messengerImageView: CircleImageView

    init {
        messageTextView =
            itemView.findViewById<View>(R.id.messageTextView) as TextView
        messageImageView =
            itemView.findViewById<View>(R.id.messageImageView) as ImageView
        messengerTextView =
            itemView.findViewById<View>(R.id.messengerTextView) as TextView
        messengerImageView =
            itemView.findViewById<View>(R.id.messengerImageView) as CircleImageView
    }
}