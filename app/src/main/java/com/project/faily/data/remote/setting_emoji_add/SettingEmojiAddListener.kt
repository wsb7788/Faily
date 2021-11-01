package com.project.faily.data.remote.setting_emoji_add

import com.project.faily.data.remote.setting_emoji.Emoji

interface SettingEmojiAddListener {
    fun onFailure(message: String)
    fun onSuccess(result: ArrayList<Emoji>)


}