package com.project.faily.data.repository.schedule_add

import com.project.faily.data.entities.Schedule
import com.project.faily.data.remote.question.QuestionService
import com.project.faily.data.remote.qustion_all.AllQuestionResponse

import com.project.faily.data.remote.qustion_all.QuestionAllService
import com.project.faily.data.remote.schedule_add.AddCalendarResponse
import com.project.faily.data.remote.schedule_add.ScheduleAddService
import com.project.faily.data.repository.BaseRepository

class ScheduleAddRepository(private val scheduleAddService: ScheduleAddService): BaseRepository() {

    suspend fun allQuestion(schedule:Schedule): AddCalendarResponse {
        return apiRequest { scheduleAddService.addCalendar(schedule) }
    }

}