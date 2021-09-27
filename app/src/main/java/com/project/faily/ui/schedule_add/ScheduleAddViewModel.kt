package com.project.faily.ui.schedule_add





import androidx.lifecycle.ViewModel
import com.project.faily.data.BaseRepository
import com.project.faily.data.remote.home.HomeListener
import com.project.faily.data.remote.login.LoginListener
import com.project.faily.data.remote.main.MainListener
import com.project.faily.data.remote.schedule_add.ScheduleAddListener

class ScheduleAddViewModel: ViewModel(){
    var scheduleAddListener:ScheduleAddListener? = null
}