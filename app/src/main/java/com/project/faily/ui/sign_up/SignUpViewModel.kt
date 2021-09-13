package com.project.faily.ui.sign_up





import androidx.lifecycle.ViewModel
import com.project.faily.data.BaseRepository
import com.project.faily.data.remote.login.LoginListener
import com.project.faily.data.remote.sign_up.SignUpListener
import com.project.faily.data.remote.splash.SplashListener

class SignUpViewModel: ViewModel(){
    var signUpListener: SignUpListener? = null
}