package com.project.faily.data.remote.calendar

import com.project.faily.data.entities.SendAnswerBody
import com.project.faily.data.entities.User
import retrofit2.Response
import retrofit2.http.*

interface CalendarService {
    @GET("/Calendar/")
    suspend fun calendar(
    ): Response<CalendarResponse>

}