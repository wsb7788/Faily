package com.project.faily.data.remote.home

import com.project.faily.data.entities.User
import retrofit2.Response
import retrofit2.http.*

interface HomeService {
    @POST("/todayQuestion/")
    suspend fun todayQuestion(
    ): Response<TodayQuestionResponse>

}