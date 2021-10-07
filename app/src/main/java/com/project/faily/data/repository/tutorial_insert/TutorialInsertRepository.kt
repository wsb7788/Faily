package com.project.faily.data.repository.tutorial_insert

import com.project.faily.data.entities.GroupCode
import com.project.faily.data.entities.User
import com.project.faily.data.remote.email_auth.EmailAuthService
import com.project.faily.data.remote.email_auth.JoinDoResponse
import com.project.faily.data.remote.email_auth.SendEmailResponse
import com.project.faily.data.remote.login.LoginResponse
import com.project.faily.data.remote.login.LoginService
import com.project.faily.data.remote.tutorial_insert.EntryChatResponse
import com.project.faily.data.remote.tutorial_insert.TutorialInsertService
import com.project.faily.data.repository.BaseRepository

class TutorialInsertRepository(private val tutorialInsertService: TutorialInsertService): BaseRepository() {
    suspend fun entryChat(groupCode: GroupCode): EntryChatResponse {
        return apiRequest { tutorialInsertService.entryChat(groupCode) }
    }
}