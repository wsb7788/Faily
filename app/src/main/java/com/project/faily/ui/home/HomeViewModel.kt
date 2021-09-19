package com.project.faily.ui.home





import androidx.lifecycle.ViewModel
import com.project.faily.data.BaseRepository
import com.project.faily.data.remote.home.HomeListener
import com.project.faily.data.remote.login.LoginListener

class HomeViewModel: ViewModel(){
    var homeListener: HomeListener? = null
}