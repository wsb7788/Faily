package com.project.faily.data.remote.chat

import com.project.faily.data.entities.Chat
import retrofit2.Response
import retrofit2.http.*

interface ChatService {
    @POST("/chat/msg/")
    suspend fun chatMsg(
        @Body chat: Chat
    ): Response<ChatMsgResponse>
    @GET("/chat/list/")
    suspend fun chatList(
    ): Response<ChatMsgResponse>

}