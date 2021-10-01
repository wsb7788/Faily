package com.project.faily.data.remote.email_auth

import com.project.faily.data.entities.User
import retrofit2.Response
import retrofit2.http.*

interface EmailAuthService {
    @Headers("Accept: application/json")
    @POST("/SendEmail/")
    suspend fun sendEmail(
        @Body user: User
    ): Response<SendEmailResponse>

    @Headers("Accept: application/json")
    @POST("/joindo/")
    suspend fun joinDo(
        @Body user: User
    ): Response<JoinDoResponse>


}