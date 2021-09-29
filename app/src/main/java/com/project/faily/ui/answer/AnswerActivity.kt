package com.project.faily.ui.answer

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.databinding.DataBindingUtil
import com.google.android.material.navigation.NavigationBarView
import com.project.faily.R
import com.project.faily.data.remote.answer.AnswerListener
import com.project.faily.data.remote.main.MainListener
import com.project.faily.databinding.ActivityAnswerBinding
import com.project.faily.databinding.ActivityMainBinding
import com.project.faily.ui.BaseActivity
import com.project.faily.ui.calendar.CalendarFragment
import com.project.faily.ui.gallery.GalleryFragment
import com.project.faily.ui.home.HomeFragment
import com.project.faily.ui.question.QuestionFragment
import com.project.faily.ui.setting.SettingFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class AnswerActivity : BaseActivity(), AnswerListener {
    private lateinit var binding: ActivityAnswerBinding
    private val viewModel: AnswerViewModel by viewModel()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_answer)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        viewModel.answerListener = this



    }


}