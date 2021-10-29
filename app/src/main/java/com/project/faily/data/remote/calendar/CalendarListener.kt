package com.project.faily.data.remote.calendar

interface CalendarListener {
    fun onFailure(message: String)
    fun onSuccess(list: ArrayList<CalendarList>)


}