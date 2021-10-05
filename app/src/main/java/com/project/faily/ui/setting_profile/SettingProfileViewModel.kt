package com.project.faily.ui.setting_profile





import androidx.lifecycle.ViewModel
import com.project.faily.data.remote.setting.SettingListener
import com.project.faily.data.remote.setting_profile.SettingProfileListener

class SettingProfileViewModel: ViewModel(){
    var settingProfileListener: SettingProfileListener? = null
}