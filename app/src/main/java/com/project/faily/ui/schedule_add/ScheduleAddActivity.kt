package com.project.faily.ui.schedule_add

import android.app.AlertDialog
import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.CompoundButton
import android.widget.Switch
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import com.github.jjobes.slidedatetimepicker.SlideDateTimeListener
import com.github.jjobes.slidedatetimepicker.SlideDateTimePicker
import com.google.android.material.switchmaterial.SwitchMaterial
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.project.faily.ApplicationClass
import com.project.faily.R
import com.project.faily.data.remote.schedule_add.ScheduleAddListener
import com.project.faily.databinding.ActivityScheduleAddBinding
import com.project.faily.databinding.DialogDatetimePickerBinding
import com.project.faily.ui.BaseActivity
import com.project.faily.ui.calendar.CalendarFragment
import com.project.faily.util.SharedPreferencesManager
import com.project.faily.util.toast
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


        observeSwitch()

        binding.clScheduleColor.setOnClickListener(this)
        binding.clRepeat.setOnClickListener(this)
        binding.tvStart.setOnClickListener(this)
        binding.tvEnd.setOnClickListener(this)
        binding.btnSave.setOnClickListener(this)
        binding.btnCancel.setOnClickListener(this)
    }

    private fun observeSwitch() {
        viewModel.allDay.observe(this, {
            if(viewModel.allDay.value!!){
                binding.tvStart.setTextColor(resources.getColor(R.color.grayscale_3))
                binding.tvEnd.setTextColor(resources.getColor(R.color.grayscale_3))
            }else{
                binding.tvStart.setTextColor(resources.getColor(R.color.grayscale_1))
                binding.tvEnd.setTextColor(resources.getColor(R.color.grayscale_1))
            }
        })
    }

    override fun onClick(v: View?) {
        when(v){
            binding.clScheduleColor -> dialogColor()
            binding.clRepeat -> dialogRepeat()
            binding.tvStart -> dialogDateTime(0)
            binding.tvEnd -> dialogDateTime(1)
            binding.btnSave -> viewModel.saveSchedule()
            binding.btnCancel -> finish()
        }
    }

    private fun dialogDateTime(type:Int) {
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
                0->tab.text="??????"
                1->tab.text="??????"
            }
        }.attach()
        val manager = SharedPreferencesManager(applicationContext)

        view.btnOk.setOnClickListener {
            if(type ==0){
                binding.tvStart.text = manager.getDate() + manager.getTime()
            }else
                binding.tvEnd.text = manager.getDate() + manager.getTime()
            alertDialog.dismiss()
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
               0-> binding.tvRepeat.text = "??????"
               1-> binding.tvRepeat.text = "??????"
               2-> binding.tvRepeat.text = "??????"
               3-> binding.tvRepeat.text = "??????"
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

    override fun onFailure(message: String) {
        applicationContext.toast(message)
    }

    override fun onSuccess(message: String) {
        applicationContext.toast(message)
        finish()
    }


}