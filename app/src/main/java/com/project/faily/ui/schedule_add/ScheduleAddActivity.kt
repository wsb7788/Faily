package com.project.faily.ui.schedule_add

import android.app.AlertDialog
import android.content.res.ColorStateList
import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import com.github.jjobes.slidedatetimepicker.SlideDateTimeListener
import com.github.jjobes.slidedatetimepicker.SlideDateTimePicker
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.project.faily.ApplicationClass
import com.project.faily.R
import com.project.faily.data.remote.schedule_add.ScheduleAddListener
import com.project.faily.databinding.ActivityScheduleAddBinding
import com.project.faily.databinding.DialogDatetimePickerBinding
import com.project.faily.ui.BaseActivity
import com.project.faily.ui.calendar.CalendarFragment
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.util.*

class ScheduleAddActivity : BaseActivity(), ScheduleAddListener,TabLayout.OnTabSelectedListener{
    private lateinit var binding: ActivityScheduleAddBinding
    private val viewModel: ScheduleAddViewModel by viewModel()
    private lateinit var view: DialogDatetimePickerBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_schedule_add)

        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        viewModel.scheduleAddListener = this


        binding.clScheduleColor.setOnClickListener(this)
        binding.clRepeat.setOnClickListener(this)
        binding.tvStart.setOnClickListener(this)
        binding.tvEnd.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v){
            binding.clScheduleColor -> dialogColor()
            binding.clRepeat -> dialogRepeat()
            binding.tvStart -> dialogDateTime()
        }
    }

    private fun dialogDateTime() {
        val dialogBuilder = AlertDialog.Builder(this)
        view = DialogDatetimePickerBinding.inflate(layoutInflater)
        dialogBuilder.setView(view.root)
        val alertDialog = dialogBuilder.create()
        alertDialog.show()

        view.tabLayout.addOnTabSelectedListener(this)
        val adapter = TimeViewPagerAdapter(supportFragmentManager,lifecycle)
        view.frame.adapter = adapter
        TabLayoutMediator(view.tabLayout, view.frame){tab,position->
            when(position){
                0->tab.text="날짜"
                1->tab.text="시간"
            }
        }.attach()
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

    override fun onTabSelected(tab: TabLayout.Tab?) {
        view.frame.currentItem = tab!!.position

    }

    override fun onTabUnselected(tab: TabLayout.Tab?) {

    }

    override fun onTabReselected(tab: TabLayout.Tab?) {
    }

}