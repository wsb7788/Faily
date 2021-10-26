package com.project.faily.data.remote.question

import com.project.faily.data.entities.User
import retrofit2.Response
import retrofit2.http.*

interface QuestionService {
    @GET("/todayQuestion/")
    suspend fun todayQuestion(
    ): Response<TodayQuestionResponse>

    @GET("/allQuestion/")
    suspend fun allQuestion(
    ): Response<AllQuestionResponse>
}