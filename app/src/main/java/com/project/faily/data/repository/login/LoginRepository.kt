package com.project.faily.data.repository.login

import com.project.faily.data.entities.User
import com.project.faily.data.remote.email_auth.EmailAuthService
import com.project.faily.data.remote.email_auth.JoinDoResponse
import com.project.faily.data.remote.email_auth.SendEmailResponse
import com.project.faily.data.remote.login.LoginResponse
import com.project.faily.data.remote.login.LoginService
import com.project.faily.data.repository.BaseRepository

class LoginRepository(private val loginService: LoginService): BaseRepository() {
    suspend fun login(user: User): LoginResponse {
        return apiRequest { loginService.login(user) }
    }
}
