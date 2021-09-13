package com.project.faily.ui.splash





import androidx.lifecycle.ViewModel
import com.project.faily.data.BaseRepository
import com.project.faily.data.remote.login.LoginListener
import com.project.faily.data.remote.splash.SplashListener

class SplashViewModel: ViewModel(){
    var splashListener: SplashListener? = null
}