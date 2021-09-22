package com.project.faily.ui.setting





import androidx.lifecycle.ViewModel
import com.project.faily.data.BaseRepository
import com.project.faily.data.remote.home.HomeListener
import com.project.faily.data.remote.login.LoginListener
import com.project.faily.data.remote.setting.SettingListener

class SettingViewModel: ViewModel(){
    var settingListener: SettingListener? = null
}