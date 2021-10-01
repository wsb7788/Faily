package com.project.faily.data.repository.email_auth

import com.project.faily.data.entities.User
import com.project.faily.data.remote.email_auth.EmailAuthService
import com.project.faily.data.remote.email_auth.JoinDoResponse
import com.project.faily.data.remote.email_auth.SendEmailResponse
import com.project.faily.data.repository.BaseRepository

class EmailAuthRepository(private val emailAuthService: EmailAuthService): BaseRepository() {
    suspend fun sendEmail(user: User): SendEmailResponse {
        return apiRequest { emailAuthService.sendEmail(user) }
    }
    suspend fun joinDo(user: User): JoinDoResponse {
        return apiRequest { emailAuthService.joinDo(user) }
    }

}