package com.project.faily.ui.setting_emoji_add





import androidx.lifecycle.ViewModel
import com.project.faily.data.remote.setting.SettingListener
import com.project.faily.data.remote.setting_app.SettingAppListener
import com.project.faily.data.remote.setting_emoji.SettingEmojiListener
import com.project.faily.data.remote.setting_emoji_add.SettingEmojiAddListener
import com.project.faily.data.remote.setting_profile.SettingProfileListener
import com.project.faily.data.repository.setting_emoji.SettingEmojiRepository
import com.project.faily.util.Coroutines

class SettingEmojiAddViewModel(private val repository: SettingEmojiRepository): ViewModel(){
    fun loadEmoji() {

        Coroutines.main {

            try {
                val response = repository.emojis()

                if(response.isSuccess){
                    settingEmojiAddListener!!.onSuccess(response.result)
                    return@main
                }
                settingEmojiAddListener!!.onFailure(response.message)

            }catch (e:Exception){
                settingEmojiAddListener!!.onFailure(e.message!!)
            }

        }

    }

    var settingEmojiAddListener:SettingEmojiAddListener? = null
}