package com.project.faily.data.remote.qustion_all

import com.project.faily.data.entities.User
import retrofit2.Response
import retrofit2.http.*

interface QuestionAllService {


    @POST("/allQuestion/")
    suspend fun allQuestion(
    ): Response<AllQuestionResponse>

}