package com.project.faily.ui.schedule_add





import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.project.faily.ApplicationClass
import com.project.faily.data.entities.Schedule
import com.project.faily.data.remote.schedule_add.ScheduleAddListener
import com.project.faily.data.repository.schedule_add.ScheduleAddRepository
import com.project.faily.util.Coroutines
import com.project.faily.util.getWeekDay
import java.lang.Exception
import java.text.SimpleDateFormat
import java.util.*

class ScheduleAddViewModel(private val repository: ScheduleAddRepository): ViewModel(){

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
            postValue("안함")
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
        if(category.value.toString().isNullOrEmpty()){
            scheduleAddListener!!.onFailure("일정구분을 해주세요")
            return
        }

        var start = startTime.value.toString()
        val parse1 = start.subSequence(0,4)
        val parse2 = start.subSequence(5,7)
        val parse3 = start.subSequence(8,10)
        val parse4 = start.subSequence(17,22)
        start = "$parse1-$parse2-$parse3 $parse4"
        var end = endTime.value.toString()
        val parse5 = end.subSequence(0,4)
        val parse6 = end.subSequence(5,7)
        val parse7 = end.subSequence(8,10)
        val parse8 = end.subSequence(17,22)
        end = "$parse5-$parse6-$parse7 $parse8"

        Coroutines.main {
            try {
                val response = repository.allQuestion(Schedule(category.value.toString(),title.value.toString(),place.value.toString(),memo.value.toString(),start,end))

                if (response.isSuccess){
                    scheduleAddListener!!.onSuccess(response.message)
                    return@main
                }
                scheduleAddListener!!.onFailure(response.message)
            }catch (e:Exception){
                scheduleAddListener!!.onFailure(e.message!!)
            }
        }


    }

}