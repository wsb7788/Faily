package com.project.faily.ui.email_auth





import androidx.lifecycle.ViewModel
import com.project.faily.data.BaseRepository
import com.project.faily.data.remote.email_auth.EmailAuthListener
import com.project.faily.data.remote.login.LoginListener
import com.project.faily.data.remote.sign_up.SignUpListener
import com.project.faily.data.remote.splash.SplashListener

class EmailAuthViewModel: ViewModel(){
    var emailAuthListener: EmailAuthListener? = null
}