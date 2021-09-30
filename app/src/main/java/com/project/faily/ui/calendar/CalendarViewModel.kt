package com.project.faily.ui.calendar





import androidx.lifecycle.ViewModel
import com.project.faily.data.remote.calendar.CalendarListener

class CalendarViewModel: ViewModel(){
    var calendarListener: CalendarListener? = null
}