package com.project.faily.ui.calendar

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import com.project.faily.ApplicationClass
import com.project.faily.R
import com.project.faily.data.remote.calendar.CalendarListener
import com.project.faily.databinding.FragmentCalendarBinding
import com.project.faily.ui.BaseFragment
import com.prolificinteractive.materialcalendarview.CalendarDay
import com.prolificinteractive.materialcalendarview.CalendarMode
import com.prolificinteractive.materialcalendarview.format.DateFormatTitleFormatter
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.text.SimpleDateFormat
import java.util.*


class CalendarFragment : BaseFragment(), CalendarListener {

    private var _binding: FragmentCalendarBinding? = null
    private val binding get() = _binding!!
    private val viewModel: CalendarViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       _binding = FragmentCalendarBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        viewModel.calendarListener = this


        calendarInit()


        binding.calendar.setWeekDayTextAppearance(R.style.calendar_day)

        binding.calendar.setHeaderTextAppearance(R.style.calendar_title)

        binding.calendar.setOnDateChangedListener { widget, date, selected ->
            if(date.day == Calendar.getInstance().get(Calendar.DATE)){
                binding.calendar.removeDecorators()
                binding.calendar.addDecorator(SelectedDayDecorator(activity, date))
            }else{
                binding.calendar.removeDecorators()
                binding.calendar.addDecorator(TodayDecorator(activity, CalendarDay.today()))
            }

        }
        return binding.root
    }

    private fun calendarInit() {
        binding.calendar.state().edit()
            .setFirstDayOfWeek(Calendar.SUNDAY)
            .setMaximumDate(CalendarDay.from(2030,11,31))
            .setMinimumDate(CalendarDay.from(2017,0,1))
            .setCalendarDisplayMode(CalendarMode.MONTHS)
            .commit()

        binding.calendar.selectedDate = CalendarDay.today()

        binding.calendar.setTitleFormatter(DateFormatTitleFormatter(SimpleDateFormat("yyyy M월")))

        val mydate=CalendarDay.from(2021,8,10)
        binding.calendar.addDecorators(TodayDecorator(activity,mydate))

    }

    override fun onClick(v: View?) {
        when(v){

        }
    }
}