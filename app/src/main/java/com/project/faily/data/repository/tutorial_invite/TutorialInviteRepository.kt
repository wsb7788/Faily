package com.project.faily.data.repository.tutorial_invite

import com.project.faily.data.entities.GroupCode
import com.project.faily.data.remote.tutorial_insert.EntryChatResponse
import com.project.faily.data.remote.tutorial_invite.GroupCodeResponse
import com.project.faily.data.remote.tutorial_invite.TutorialInviteService
import com.project.faily.data.repository.BaseRepository

class TutorialInviteRepository(private val tutorialInviteService: TutorialInviteService): BaseRepository() {
    suspend fun groupCode(): GroupCodeResponse {
        return apiRequest { tutorialInviteService.groupCode() }
    }
}