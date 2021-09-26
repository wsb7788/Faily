package com.project.faily.ui.calendar

import android.app.Activity
import android.graphics.Typeface
import android.text.style.ForegroundColorSpan
import android.text.style.StyleSpan
import androidx.core.content.ContextCompat
import com.project.faily.ApplicationClass
import com.project.faily.R
import com.prolificinteractive.materialcalendarview.CalendarDay
import com.prolificinteractive.materialcalendarview.DayViewDecorator
import com.prolificinteractive.materialcalendarview.DayViewFacade

class SelectedDayDecorator(context: Activity?, currentDay:CalendarDay) : DayViewDecorator {
    //오늘 날짜 색변경
    var myDay = currentDay



    override fun shouldDecorate(day: CalendarDay?): Boolean {
        return day!! == myDay
    }

    override fun decorate(view: DayViewFacade?) {
        view!!.addSpan(StyleSpan(Typeface.BOLD))

    }
}