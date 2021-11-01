package com.project.faily.ui.setting_emoji





import androidx.lifecycle.ViewModel
import com.project.faily.data.remote.setting.SettingListener
import com.project.faily.data.remote.setting_app.SettingAppListener
import com.project.faily.data.remote.setting_emoji.SettingEmojiListener
import com.project.faily.data.remote.setting_profile.SettingProfileListener
import com.project.faily.data.repository.setting_emoji.SettingEmojiRepository
import com.project.faily.util.Coroutines

class SettingEmojiViewModel(private val repository: SettingEmojiRepository): ViewModel(){
    fun loadEmoji() {

        Coroutines.main {

            try {
                val response = repository.emojis()

                if(response.isSuccess){
                    settingEmojiListener!!.onSuccess(response.result)
                    return@main
                }
                settingEmojiListener!!.onFailure(response.message)

            }catch (e:Exception){
                settingEmojiListener!!.onFailure(e.message!!)
            }

        }

    }

    var settingEmojiListener:SettingEmojiListener? = null
}