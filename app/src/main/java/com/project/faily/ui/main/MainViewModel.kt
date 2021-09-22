package com.project.faily.ui.main





import androidx.lifecycle.ViewModel
import com.project.faily.data.BaseRepository
import com.project.faily.data.remote.home.HomeListener
import com.project.faily.data.remote.login.LoginListener
import com.project.faily.data.remote.main.MainListener

class MainViewModel: ViewModel(){
    var mainListener: MainListener? = null
}