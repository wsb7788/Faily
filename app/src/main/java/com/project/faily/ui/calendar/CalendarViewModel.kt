package com.project.faily.ui.calendar





import androidx.lifecycle.ViewModel
import com.project.faily.data.BaseRepository
import com.project.faily.data.remote.home.HomeListener
import com.project.faily.data.remote.login.LoginListener

class CalendarViewModel: ViewModel(){
    var homeListener: HomeListener? = null
}