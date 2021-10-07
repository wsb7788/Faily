package com.project.faily.data.remote.tutorial_invite

import com.project.faily.data.entities.GroupCode
import com.project.faily.data.entities.User
import retrofit2.Response
import retrofit2.http.*

interface TutorialInviteService {

    @POST("/GroupCode/")
    suspend fun groupCode()
    : Response<GroupCodeResponse>



}