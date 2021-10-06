package com.project.faily.ui.setting_app





import androidx.lifecycle.ViewModel
import com.project.faily.data.remote.setting.SettingListener
import com.project.faily.data.remote.setting_app.SettingAppListener
import com.project.faily.data.remote.setting_profile.SettingProfileListener

class SettingAppViewModel: ViewModel(){
    var settingAppListener: SettingAppListener? = null
}