package com.project.faily.ui.chat

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
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


    private lateinit var chatRecyclerAdapter: ChatRecyclerAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_chat)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        viewModel.chatListener = this


        viewInit()


        binding.btnBack.setOnClickListener(this)
        binding.btnSend.setOnClickListener(this)
        binding.etMessage.setOnClickListener(this)
        binding.btnExpand.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v){
            binding.btnBack -> onBackPressed()
            binding.btnSend -> send()
            binding.etMessage -> hideClAdd()
            binding.btnExpand -> expandBottom()
        }
    }

    private fun expandBottom() {
        if(binding.clAdd.visibility == VISIBLE)
            hideClAdd()
        else
            showClAdd()
    }

    private fun showClAdd() {
        binding.btnExpand.animate().setDuration(50).rotation(45f)
        binding.clAdd.visibility = VISIBLE
    }

    private fun hideClAdd() {
        binding.btnExpand.animate().setDuration(50).rotation(0f)
        binding.clAdd.visibility = GONE
    }

    private fun send() {

        val model = ArrayList<ChatModel>()

        model.add(ChatModel(true,content = binding.etMessage.text.toString()))
        model.add(ChatModel(false,"구본의","어어 그래그래"))
        binding.etMessage.text = null

        chatRecyclerAdapter.submitList(model)
        chatRecyclerAdapter.notifyDataSetChanged()
        binding.rcvChat.scrollToPosition(chatRecyclerAdapter.itemCount-1)
    }

    private fun viewInit() {

        chatRecyclerAdapter = ChatRecyclerAdapter()
        val manager = LinearLayoutManager(applicationContext, LinearLayoutManager.VERTICAL,false)
        manager.stackFromEnd = true
        binding.rcvChat.apply {
            layoutManager = manager

            adapter = chatRecyclerAdapter

        }

    }

}