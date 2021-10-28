package com.project.faily.data.remote.schedule_add

interface ScheduleAddListener {
    fun onFailure(message: String)
    fun onSuccess(message: String)


}