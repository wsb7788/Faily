package com.project.faily.data.remote.chat




data class ChatMsgResponse(
    val isSuccess:Boolean,
    val code: Int,
    val message: String,
    val content : String,
    val file: String,
    val sender :  String,
    val group_code : String,
    val chatting_time : String,
    val emoji : Boolean,
    val photo: Boolean,
    val calendar : Boolean,
    val text : Boolean,)

data class ChatListResponse(
    val isSuccess:Boolean,
    val code: Int,
    val message: String,
    val content : String,
    val file: String,
    val sender :  String,
    val group_code : String,
    val chatting_time : String,
    val emoji : Boolean,
    val photo: Boolean,
    val calendar : Boolean,
    val text : Boolean,)

