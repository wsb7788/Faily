package com.project.faily.data.repository.question_all

import com.project.faily.data.remote.question.QuestionService
import com.project.faily.data.remote.qustion_all.AllQuestionResponse

import com.project.faily.data.remote.qustion_all.QuestionAllService
import com.project.faily.data.repository.BaseRepository

class QuestionAllRepository(private val questionAllService: QuestionAllService): BaseRepository() {

    suspend fun allQuestion(): AllQuestionResponse {
        return apiRequest { questionAllService.allQuestion() }
    }

}