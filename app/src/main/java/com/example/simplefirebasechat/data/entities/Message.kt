package com.example.simplefirebasechat.data.entities

data class Message(
    private val id: Int,
    private val text: String,
    private val name: String,
    private val photoUrl: String,
    private val imageUrl: String
)