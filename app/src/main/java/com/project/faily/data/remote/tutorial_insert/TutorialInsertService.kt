package com.project.faily.data.remote.tutorial_insert

import com.project.faily.data.entities.GroupCode
import com.project.faily.data.entities.User
import retrofit2.Response
import retrofit2.http.*

interface TutorialInsertService {

    @POST("/EntryChat/")
    suspend fun entryChat(
        @Body groupCode: GroupCode
    ): Response<EntryChatResponse>



}