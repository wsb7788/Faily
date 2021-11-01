package com.project.faily.ui.setting_emoji





import androidx.lifecycle.ViewModel
import com.project.faily.data.remote.setting.SettingListener
import com.project.faily.data.remote.setting_app.SettingAppListener
import com.project.faily.data.remote.setting_emoji.SettingEmojiListener
import com.project.faily.data.remote.setting_profile.SettingProfileListener

class SettingEmojiViewModel: ViewModel(){
    var settingEmojiListener:SettingEmojiListener? = null
}