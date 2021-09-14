package com.project.faily.ui.sign_in





import androidx.lifecycle.ViewModel
import com.project.faily.data.BaseRepository
import com.project.faily.data.remote.login.LoginListener
import com.project.faily.data.remote.sign_in.SignInListener
import com.project.faily.data.remote.sign_up.SignUpListener
import com.project.faily.data.remote.splash.SplashListener

class SignInViewModel: ViewModel(){
    var signinListener: SignInListener? = null
}