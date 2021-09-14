package com.project.faily.ui.permission





import androidx.lifecycle.ViewModel
import com.project.faily.data.BaseRepository
import com.project.faily.data.remote.login.LoginListener
import com.project.faily.data.remote.permission.PermissionListener
import com.project.faily.data.remote.sign_in.SignInListener
import com.project.faily.data.remote.sign_up.SignUpListener
import com.project.faily.data.remote.splash.SplashListener

class PermissionViewModel: ViewModel(){
    var permissionListener: PermissionListener? = null
}