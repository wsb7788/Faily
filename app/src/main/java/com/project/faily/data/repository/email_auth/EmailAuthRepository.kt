package com.project.faily.data.repository.email_auth

import com.project.faily.data.entities.Email
import com.project.faily.data.remote.email_auth.EmailAuthService
import com.project.faily.data.remote.email_auth.SendEmailResponse
import com.project.faily.data.repository.BaseRepository

class EmailAuthRepository(private val emailAuthService: EmailAuthService): BaseRepository() {
    suspend fun sendEmail(user_email: Email): SendEmailResponse {
        return apiRequest { emailAuthService.sendEmail(user_email) }
    }

}