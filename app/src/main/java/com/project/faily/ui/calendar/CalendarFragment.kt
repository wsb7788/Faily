package com.project.faily.ui.calendar

import android.app.Activity
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.project.faily.ApplicationClass
import com.project.faily.R
import com.project.faily.data.remote.calendar.CalendarList
import com.project.faily.data.remote.calendar.CalendarListener
import com.project.faily.databinding.FragmentCalendarBinding
import com.project.faily.ui.BaseFragment
import com.project.faily.ui.schedule_add.ScheduleAddActivity
import com.project.faily.util.toast
import com.prolificinteractive.materialcalendarview.CalendarDay
import com.prolificinteractive.materialcalendarview.CalendarMode
import com.prolificinteractive.materialcalendarview.format.DateFormatTitleFormatter
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList


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


        viewModel.calendarLoad()
        calendarInit()


        binding.calendar.setWeekDayTextAppearance(R.style.calendar_day)
        binding.calendar.setHeaderTextAppearance(R.style.calendar_title)

        binding.clAdd.setOnClickListener(this)
        return binding.root
    }

    private fun calendarInit() {
        binding.calendar.state().edit()
            .setFirstDayOfWeek(Calendar.SUNDAY)
            .setMaximumDate(CalendarDay.from(2030,11,31))
            .setMinimumDate(CalendarDay.from(2017,0,1))
            .setCalendarDisplayMode(CalendarMode.MONTHS)
            .commit()

       // binding.calendar.selectedDate = CalendarDay.today()

        binding.calendar.setTitleFormatter(DateFormatTitleFormatter(SimpleDateFormat("yyyy M월")))





    }

    override fun onClick(v: View?) {
        when(v){
            binding.clAdd->{
                val intent= Intent(requireContext(),ScheduleAddActivity::class.java)
                startActivity(intent)


            }
        }
    }

    override fun onFailure(message: String) {
        requireContext().toast(message)
    }

    override fun onSuccess(list: ArrayList<CalendarList>) {
        val event = ArrayList<CalendarDay>()

        //binding.calendar.addDecorator(TodayDecorator(activity))
        binding.calendar.selectedDate = CalendarDay.today()

        for(i in 0 until list.size){
            val date = CalendarDay.from(list[i].calendar_date.substring(0, 4).toInt(), list[i].calendar_date.substring(5, 7).toInt()-1, list[i].calendar_date.substring(8, 10).toInt())
            event.add(date)
        }
        binding.calendar.addDecorators(TodayDecorator(activity),SelectedDayDecorator(activity, CalendarDay.today()),EventDecorator(event,requireContext()))

        binding.calendar.setOnDateChangedListener { widget, date, selected ->

            if(date.day == Calendar.getInstance().get(Calendar.DATE)){
                binding.calendar.removeDecorators()
                binding.calendar.addDecorators(TodayDecorator(activity),SelectedDayDecorator(activity, date),EventDecorator(event,requireContext()))
            }else{
                binding.calendar.removeDecorators()
                binding.calendar.addDecorators(TodayDecorator(activity),EventDecorator(event,requireContext()))

            }
        }
    }
}