package com.project.faily.data.remote.email_auth

import com.google.gson.annotations.SerializedName
import com.project.faily.data.entities.Email
import retrofit2.Response
import retrofit2.http.*

interface EmailAuthService {
    @Headers("Accept: application/json")
    @POST("/SendEmail/")
    suspend fun sendEmail(
        @Body email: Email
    ): Response<SendEmailResponse>


}