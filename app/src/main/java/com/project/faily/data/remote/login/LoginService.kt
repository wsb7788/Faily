package com.project.faily.data.remote.login

import com.project.faily.data.entities.User
import retrofit2.Response
import retrofit2.http.*

interface LoginService {
    @Headers("Accept: application/json")
    @POST("/login/")
    suspend fun login(
        @Body user: User
    ): Response<LoginResponse>

}