package com.project.faily.data.remote.setting_emoji

interface SettingEmojiListener {
    fun onFailure(message: String)
    fun onSuccess(result: ArrayList<Emoji>)


}