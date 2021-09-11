package com.project.faily.ui.login





import androidx.lifecycle.ViewModel
import com.project.faily.data.BaseRepository
import com.project.faily.data.remote.login.LoginListener

class LoginViewModel: ViewModel(){
    var loginListener: LoginListener? = null
}