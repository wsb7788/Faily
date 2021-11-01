package com.project.faily.data.repository.setting_emoji

import com.project.faily.data.entities.Schedule
import com.project.faily.data.remote.question.QuestionService
import com.project.faily.data.remote.qustion_all.AllQuestionResponse

import com.project.faily.data.remote.qustion_all.QuestionAllService
import com.project.faily.data.remote.schedule_add.AddCalendarResponse
import com.project.faily.data.remote.schedule_add.ScheduleAddService
import com.project.faily.data.remote.setting_emoji.EmojisResponse
import com.project.faily.data.remote.setting_emoji.SettingEmojiService
import com.project.faily.data.repository.BaseRepository

class SettingEmojiRepository(private val settingEmojiService: SettingEmojiService): BaseRepository() {

    suspend fun emojis(): EmojisResponse {
        return apiRequest { settingEmojiService.emojis() }
    }

}