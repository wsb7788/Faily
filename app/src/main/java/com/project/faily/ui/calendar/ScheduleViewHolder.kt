package com.project.faily.ui.calendar

import android.annotation.SuppressLint
import android.content.res.Resources
import androidx.recyclerview.widget.RecyclerView
import com.project.faily.ApplicationClass
import com.project.faily.R
import com.project.faily.databinding.LayoutRecyclerHomeFamilyBinding
import com.project.faily.databinding.LayoutRecyclerHomePresentBinding
import com.project.faily.databinding.LayoutRecyclerScheduleBinding
import com.project.faily.util.SharedPreferencesManager
import com.project.faily.util.getWeekDay

class ScheduleViewHolder(val binding: LayoutRecyclerScheduleBinding): RecyclerView.ViewHolder(binding.root) {

    @SuppressLint("ResourceAsColor")
    fun bind(scheduleModel: ScheduleModel){

        when(scheduleModel.category){
            "기념일" -> binding.clOut.setBackgroundResource(R.drawable.box_schedule_anniversary)
            "가족" -> binding.clOut.setBackgroundColor(R.color.primary_pink)
            "개인" -> binding.clOut.setBackgroundColor(R.color.light_grey_green)
            "일반" -> binding.clOut.setBackgroundColor(R.color.secondary_pink)
        }

        binding.tvScheduleDay.text = scheduleModel.date.substring(8,10)
        binding.tvScheduleWeekday.text = ApplicationClass.instance.getWeekDay(scheduleModel.date)
        binding.tvTitle.text = scheduleModel.title
        binding.tvContent.text = scheduleModel.content
    }
}