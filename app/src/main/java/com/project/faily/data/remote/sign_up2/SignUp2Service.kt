package com.project.faily.data.remote.sign_up2

import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface SignUp2Service {
    @FormUrlEncoded
    @POST("/SendEmail/")
    suspend fun sendEmail(@Field("user_email") user_email: String
    ): Response<SendEmailResponse>


}