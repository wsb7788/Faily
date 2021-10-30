package com.project.faily.ui.chat

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.databinding.DataBindingUtil
import com.google.android.material.navigation.NavigationBarView
import com.project.faily.R
import com.project.faily.data.remote.chat.ChatListener
import com.project.faily.data.remote.main.MainListener
import com.project.faily.data.remote.notice.NoticeListener
import com.project.faily.databinding.ActivityChatBinding
import com.project.faily.databinding.ActivityMainBinding
import com.project.faily.databinding.ActivityNoticeBinding
import com.project.faily.ui.BaseActivity
import com.project.faily.ui.calendar.CalendarFragment
import com.project.faily.ui.gallery.GalleryFragment
import com.project.faily.ui.home.HomeFragment
import com.project.faily.ui.question.QuestionFragment
import com.project.faily.ui.setting.SettingFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class ChatActivity : BaseActivity(), ChatListener {
    private lateinit var binding: ActivityChatBinding
    private val viewModel: ChatViewModel by viewModel()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_chat)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        viewModel.chatListener = this


    }

}