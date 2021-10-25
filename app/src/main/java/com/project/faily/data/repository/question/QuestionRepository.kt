package com.project.faily.data.repository.question

import com.project.faily.data.remote.question.AllQuestionResponse
import com.project.faily.data.remote.question.QuestionService
import com.project.faily.data.remote.question.TodayQuestionResponse
import com.project.faily.data.repository.BaseRepository

class QuestionRepository(private val questionService: QuestionService): BaseRepository() {
    suspend fun todayQuestion(): TodayQuestionResponse {
        return apiRequest { questionService.todayQuestion() }
    }
    suspend fun allQuestion(): AllQuestionResponse {
        return apiRequest { questionService.allQuestion() }
    }

}