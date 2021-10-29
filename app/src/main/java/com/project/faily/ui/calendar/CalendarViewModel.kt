package com.project.faily.ui.calendar





import androidx.lifecycle.ViewModel
import com.project.faily.data.remote.calendar.CalendarListener
import com.project.faily.data.repository.calendar.CalendarRepository
import com.project.faily.util.Coroutines
import kotlinx.coroutines.CoroutineScope

class CalendarViewModel(private val repository: CalendarRepository): ViewModel(){


    var calendarListener: CalendarListener? = null

    fun calendarLoad() {


        Coroutines.main {

            try {
                val response = repository.calendar()

                if(response.isSuccess){
                    calendarListener!!.onSuccess(response.calendar)
                    return@main
                }
                calendarListener!!.onFailure(response.message)

            }catch (e:Exception){
                calendarListener!!.onFailure(e.message!!)
            }
        }
    }
}