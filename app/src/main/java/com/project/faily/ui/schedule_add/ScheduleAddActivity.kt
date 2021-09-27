package com.project.faily.ui.schedule_add

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
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
        val colorDialog = ColorDialog()
        colorDialog.show(supportFragmentManager,"")
    }
    private fun dialogRepeat() {
       val repeatDialog = RepeatDialog()
        repeatDialog.show(supportFragmentManager,"")
    }

}