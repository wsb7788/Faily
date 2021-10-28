package com.project.faily.data.remote.schedule_add

import com.project.faily.data.entities.Schedule
import com.project.faily.data.entities.User

import retrofit2.Response
import retrofit2.http.*

interface ScheduleAddService {
    @POST("/addCalendar/")
    suspend fun addCalendar(
        @Body schedule: Schedule
    ): Response<AddCalendarResponse>


}