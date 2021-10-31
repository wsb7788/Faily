package com.project.faily.data.repository.chat

import com.project.faily.data.entities.User
import com.project.faily.data.remote.calendar.CalendarResponse
import com.project.faily.data.remote.calendar.CalendarService
import com.project.faily.data.remote.chat.ChatService
import com.project.faily.data.remote.email_auth.EmailAuthService
import com.project.faily.data.remote.email_auth.JoinDoResponse
import com.project.faily.data.remote.email_auth.SendEmailResponse
import com.project.faily.data.remote.login.LoginResponse
import com.project.faily.data.remote.login.LoginService
import com.project.faily.data.repository.BaseRepository

class ChatRepository(private val chatService: ChatService): BaseRepository() {
  /*  suspend fun calendar(): CalendarResponse {
        return apiRequest { calendarService.calendar() }
    }*/
}
