package com.project.faily.data.remote.answer

import com.project.faily.data.entities.SendAnswerBody
import com.project.faily.data.entities.User
import retrofit2.Response
import retrofit2.http.*

interface AnswerService {
    @POST("/SendAnswer/")
    suspend fun sendAnswer(
        @Body answer: SendAnswerBody
    ): Response<SendAnswerResponse>

}