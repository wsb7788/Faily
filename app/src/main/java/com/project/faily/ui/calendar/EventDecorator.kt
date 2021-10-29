package com.project.faily.ui.calendar

import android.app.Activity
import android.content.Context
import android.content.res.Resources
import android.graphics.Color
import android.graphics.drawable.Drawable

import androidx.compose.ui.res.colorResource
import com.project.faily.R
import com.prolificinteractive.materialcalendarview.CalendarDay
import com.prolificinteractive.materialcalendarview.DayViewDecorator
import com.prolificinteractive.materialcalendarview.DayViewFacade
import com.prolificinteractive.materialcalendarview.spans.DotSpan

class EventDecorator(private val dates:ArrayList<CalendarDay>, private val context:Context ):DayViewDecorator {

    override fun shouldDecorate(day: CalendarDay?): Boolean{
        return dates.contains(day)
    }

    override fun decorate(view: DayViewFacade?) {
        view?.addSpan(DotSpan(5F, Color.parseColor("#FF0000")))
    }
}