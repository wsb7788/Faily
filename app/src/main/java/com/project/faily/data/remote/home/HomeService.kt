package com.project.faily.data.remote.home

import com.project.faily.data.entities.User

import retrofit2.Response
import retrofit2.http.*

interface HomeService {
    @GET("/todayQuestion/")
    suspend fun todayQuestion(
    ): Response<TodayQuestionResponse>

    @POST("/login/")
    suspend fun login(
        @Body user: User
    ): Response<LoginResponse>

    @GET("/Home/")
    suspend fun home(
    ): Response<HomeResponse>

}