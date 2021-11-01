package com.project.faily.ui.setting_emoji_add

import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.text.InputType
import android.text.SpannableStringBuilder
import android.view.View
import android.widget.CheckBox
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import com.project.faily.R
import com.project.faily.data.remote.login.LoginListener
import com.project.faily.data.remote.setting_app.SettingAppListener
import com.project.faily.data.remote.setting_emoji.Emoji
import com.project.faily.data.remote.setting_emoji.SettingEmojiListener
import com.project.faily.data.remote.setting_profile.SettingProfileListener
import com.project.faily.data.remote.sign_up.SignUpListener
import com.project.faily.databinding.*
import com.project.faily.ui.BaseActivity
import com.project.faily.ui.home.EmojiAdapter
import com.project.faily.ui.sign_up2.SignUp2Activity
import com.project.faily.util.toast
import org.koin.androidx.viewmodel.ext.android.viewModel

class SettingEmojiAddActivity : BaseActivity(), SettingEmojiListener {
    private lateinit var binding: ActivitySettingEmojiAddBinding
    private val viewModel: SettingEmojiAddViewModel by viewModel()

    private lateinit var deisgnAdapter: DesignRecyclerAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_setting_emoji_add)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        viewModel.settingEmojiAddListener = this

        recyclerInit()
        viewModel.loadEmoji()


        binding.btnBack.setOnClickListener(this)
    }

    private fun recyclerInit() {
        deisgnAdapter = DesignRecyclerAdapter()

        binding.rcvEmojiDesign.apply {
            layoutManager = GridLayoutManager(context,3,GridLayoutManager.VERTICAL,false)
            adapter = deisgnAdapter
        }



    }

    override fun onClick(v: View?) {
        when(v){
            binding.btnBack -> onBackPressed()
        }
    }

    override fun onFailure(message: String) {
        applicationContext.toast(message)
    }

    override fun onSuccess(result: ArrayList<Emoji>) {

    }
}

