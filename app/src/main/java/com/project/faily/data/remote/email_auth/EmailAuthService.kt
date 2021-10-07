package com.project.faily.data.remote.email_auth

import com.project.faily.data.entities.User
import retrofit2.Response
import retrofit2.http.*

interface EmailAuthService {

    @POST("/SendEmail/")
    suspend fun sendEmail(
        @Body user: User
    ): Response<SendEmailResponse>

    @POST("/joindo/")
    suspend fun joinDo(
        @Body user: User
    ): Response<JoinDoResponse>


}