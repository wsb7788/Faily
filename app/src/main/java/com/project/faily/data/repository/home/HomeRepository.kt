package com.project.faily.data.repository.home

import com.project.faily.data.entities.User
import com.project.faily.data.remote.email_auth.EmailAuthService
import com.project.faily.data.remote.email_auth.JoinDoResponse
import com.project.faily.data.remote.email_auth.SendEmailResponse
import com.project.faily.data.remote.home.HomeResponse
import com.project.faily.data.remote.home.HomeService
import com.project.faily.data.remote.home.LoginResponse
import com.project.faily.data.remote.home.TodayQuestionResponse

import com.project.faily.data.repository.BaseRepository

class HomeRepository(private val homeService: HomeService): BaseRepository() {
    suspend fun todayQuestion(): TodayQuestionResponse {
        return apiRequest { homeService.todayQuestion() }
    }
    suspend fun login(user: User): LoginResponse {
        return apiRequest { homeService.login(user) }
    }
    suspend fun home(): HomeResponse {
        return apiRequest { homeService.home() }
    }

}