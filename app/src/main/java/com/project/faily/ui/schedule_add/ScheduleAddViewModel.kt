package com.project.faily.ui.schedule_add





import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.project.faily.ApplicationClass
import com.project.faily.data.remote.schedule_add.ScheduleAddListener
import com.project.faily.util.Coroutines
import com.project.faily.util.getWeekDay
import java.lang.Exception
import java.text.SimpleDateFormat
import java.util.*

class ScheduleAddViewModel: ViewModel(){

    var scheduleAddListener:ScheduleAddListener? = null


    val title:MutableLiveData<String> by lazy {
        MutableLiveData<String>().apply {
            postValue("")
        }
    }
    val place:MutableLiveData<String> by lazy {
        MutableLiveData<String>().apply {
            postValue("")
        }
    }
    val memo:MutableLiveData<String> by lazy {
        MutableLiveData<String>().apply {
            postValue("")
        }
    }
    val repeat:MutableLiveData<String> by lazy {
        MutableLiveData<String>().apply {
            postValue("")
        }
    }
    val category:MutableLiveData<String> by lazy {
        MutableLiveData<String>().apply {
            postValue("")
        }
    }
    val startTime:MutableLiveData<String> by lazy {
        MutableLiveData<String>().apply {
            val now = System.currentTimeMillis()
            val format1 = SimpleDateFormat("yyyy-MM-dd")
            val format2 = SimpleDateFormat("yyyy.MM.dd")
            postValue("${format2.format(Date(now))}(${ApplicationClass.instance.getWeekDay(format1.format(Date(now)))}) 오전 12:00")
        }
    }
    val endTime:MutableLiveData<String> by lazy {
        MutableLiveData<String>().apply {
            val now = System.currentTimeMillis()
            val format1 = SimpleDateFormat("yyyy-MM-dd")
            val format2 = SimpleDateFormat("yyyy.MM.dd")
            postValue("${format2.format(Date(now))}(${ApplicationClass.instance.getWeekDay(format1.format(Date(now)))}) 오후 11:59")
        }
    }
    val allDay:MutableLiveData<Boolean> by lazy {
        MutableLiveData<Boolean>().apply {
            postValue(true)
        }
    }
    fun saveSchedule() {

        if(title.value.toString().isNullOrEmpty()){
            scheduleAddListener!!.onFailure("제목을 입력해주세요")
            return
        }

        Coroutines.main {
            try {


            }catch (e:Exception){
                scheduleAddListener!!.onFailure(e.message!!)
            }
        }


    }

}