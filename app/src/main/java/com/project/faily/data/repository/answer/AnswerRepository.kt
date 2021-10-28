package com.project.faily.data.repository.answer

import com.project.faily.data.entities.SendAnswerBody
import com.project.faily.data.entities.User
import com.project.faily.data.remote.answer.AnswerService
import com.project.faily.data.remote.answer.SendAnswerResponse
import com.project.faily.data.remote.email_auth.EmailAuthService
import com.project.faily.data.remote.email_auth.JoinDoResponse
import com.project.faily.data.remote.email_auth.SendEmailResponse
import com.project.faily.data.repository.BaseRepository

class AnswerRepository(private val answerService: AnswerService): BaseRepository() {
    suspend fun sendAnswer(answerBody: SendAnswerBody): SendAnswerResponse {
        return apiRequest { answerService.sendAnswer(answerBody) }
    }


}