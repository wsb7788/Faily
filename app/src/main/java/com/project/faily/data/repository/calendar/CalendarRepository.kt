package com.project.faily.data.repository.calendar

import com.project.faily.data.entities.User
import com.project.faily.data.remote.calendar.CalendarResponse
import com.project.faily.data.remote.calendar.CalendarService
import com.project.faily.data.remote.email_auth.EmailAuthService
import com.project.faily.data.remote.email_auth.JoinDoResponse
import com.project.faily.data.remote.email_auth.SendEmailResponse
import com.project.faily.data.remote.login.LoginResponse
import com.project.faily.data.remote.login.LoginService
import com.project.faily.data.repository.BaseRepository

class CalendarRepository(private val calendarService: CalendarService): BaseRepository() {
    suspend fun calendar(): CalendarResponse {
        return apiRequest { calendarService.calendar() }
    }
}
