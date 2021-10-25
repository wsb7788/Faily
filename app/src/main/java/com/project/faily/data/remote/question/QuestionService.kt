package com.project.faily.data.remote.question

import com.project.faily.data.entities.User
import retrofit2.Response
import retrofit2.http.*

interface QuestionService {
    @POST("/todayQuestion/")
    suspend fun todayQuestion(
    ): Response<TodayQuestionResponse>

    @POST("/allQuestion/")
    suspend fun allQuestion(
    ): Response<AllQuestionResponse>
}