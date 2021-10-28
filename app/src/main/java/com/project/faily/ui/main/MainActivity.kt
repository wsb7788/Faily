package com.project.faily.ui.main

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.databinding.DataBindingUtil
import com.google.android.material.navigation.NavigationBarView
import com.project.faily.R
import com.project.faily.data.remote.main.MainListener
import com.project.faily.databinding.ActivityMainBinding
import com.project.faily.ui.BaseActivity
import com.project.faily.ui.calendar.CalendarFragment
import com.project.faily.ui.gallery.GalleryFragment
import com.project.faily.ui.home.HomeFragment
import com.project.faily.ui.question.QuestionFragment
import com.project.faily.ui.setting.SettingFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : BaseActivity(), MainListener, NavigationBarView.OnItemSelectedListener {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModel()
    val manager = supportFragmentManager


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        viewModel.mainListener = this


        binding.bnv.menu.getItem(2).isEnabled = false
        showTabHome()


        binding.bnv.setOnItemSelectedListener(this)
        binding.btnHome.setOnClickListener(this)
    }


    override fun onClick(v: View?) {
        when (v) {
            binding.btnHome -> {

                showTabHome()
            }
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        binding.btnHome.setImageResource(R.drawable.menu_home)
        when (item.itemId) {
            R.id.menu_question -> showTabQuestion()
            R.id.menu_calendar -> showTabCalendar()
            R.id.menu_gallery -> showTabGallery()
            R.id.menu_setting -> showTabSetting()
        }
        return true
    }

    private fun showTabHome() {
        binding.btnHome.setImageResource(R.drawable.menu_home_checked)
        binding.bnv.selectedItemId = R.id.menu_home
        val transaction = manager.beginTransaction()
        val fragment = HomeFragment()
        transaction.replace(binding.fragment.id, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

    private fun showTabCalendar() {
        val transaction = manager.beginTransaction()
        val fragment = CalendarFragment()
        transaction.replace(binding.fragment.id, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

    private fun showTabGallery() {
        val transaction = manager.beginTransaction()
        val fragment = GalleryFragment()
        transaction.replace(binding.fragment.id, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

    private fun showTabSetting() {
        val transaction = manager.beginTransaction()
        val fragment = SettingFragment()
        transaction.replace(binding.fragment.id, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

    private fun showTabQuestion() {
        val transaction = manager.beginTransaction()
        val fragment = QuestionFragment()
        transaction.replace(binding.fragment.id, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }


}