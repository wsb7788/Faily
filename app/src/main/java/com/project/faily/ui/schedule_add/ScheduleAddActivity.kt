package com.project.faily.ui.schedule_add

import android.content.Context
import android.content.res.ColorStateList
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.navigation.NavigationBarView
import com.project.faily.ApplicationClass
import com.project.faily.R
import com.project.faily.data.remote.main.MainListener
import com.project.faily.data.remote.schedule_add.ScheduleAddListener
import com.project.faily.databinding.ActivityMainBinding
import com.project.faily.databinding.ActivityScheduleAddBinding
import com.project.faily.databinding.DialogScheduleColorBinding
import com.project.faily.ui.BaseActivity
import com.project.faily.ui.calendar.CalendarFragment
import com.project.faily.ui.gallery.GalleryFragment
import com.project.faily.ui.home.HomeFragment
import com.project.faily.ui.question.QuestionFragment
import com.project.faily.ui.setting.SettingFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class ScheduleAddActivity : BaseActivity(), ScheduleAddListener{
    private lateinit var binding: ActivityScheduleAddBinding
    private val viewModel: ScheduleAddViewModel by viewModel()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_schedule_add)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        viewModel.scheduleAddListener = this


        binding.clScheduleColor.setOnClickListener(this)
        binding.clRepeat.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v){
            binding.clScheduleColor -> dialogColor()
            binding.clRepeat -> dialogRepeat()
        }
    }

    private fun dialogColor() {
        val colorDialog = ColorDialog{
            when(it){
                0 -> {
                    binding.ivScheduleColor.setImageResource(R.drawable.box_schedule_anniversary)
                }
                1->{
                    binding.ivScheduleColor.imageTintList = ColorStateList.valueOf(ContextCompat.getColor(ApplicationClass.instance, R.color.primary_pink))
                }
                2->{
                    binding.ivScheduleColor.imageTintList = ColorStateList.valueOf(ContextCompat.getColor(ApplicationClass.instance, R.color.light_grey_green))
                }
                3->{
                    binding.ivScheduleColor.imageTintList = ColorStateList.valueOf(ContextCompat.getColor(ApplicationClass.instance, R.color.secondary_pink))
                }
            }
        }
        colorDialog.show(supportFragmentManager,"")
    }
    private fun dialogRepeat() {
       val repeatDialog = RepeatDialog(binding.tvRepeat.text.toString()){
           when(it){
               0-> binding.tvRepeat.text = "안함"
               1-> binding.tvRepeat.text = "매주"
               2-> binding.tvRepeat.text = "매월"
               3-> binding.tvRepeat.text = "매년"
           }
       }
        repeatDialog.show(supportFragmentManager,"")
    }

}