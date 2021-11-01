package com.project.faily.data.remote.setting_emoji

import com.project.faily.data.entities.Schedule
import com.project.faily.data.entities.User

import retrofit2.Response
import retrofit2.http.*

interface SettingEmojiService {
    @GET("/emojis/")
    suspend fun emojis(
    ): Response<EmojisResponse>


}