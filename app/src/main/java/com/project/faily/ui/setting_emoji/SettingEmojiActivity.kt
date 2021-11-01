package com.project.faily.ui.setting_emoji

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
import com.project.faily.R
import com.project.faily.data.remote.login.LoginListener
import com.project.faily.data.remote.setting_app.SettingAppListener
import com.project.faily.data.remote.setting_emoji.SettingEmojiListener
import com.project.faily.data.remote.setting_profile.SettingProfileListener
import com.project.faily.data.remote.sign_up.SignUpListener
import com.project.faily.databinding.*
import com.project.faily.ui.BaseActivity
import com.project.faily.ui.sign_up2.SignUp2Activity
import org.koin.androidx.viewmodel.ext.android.viewModel

class SettingEmojiActivity : BaseActivity(), SettingEmojiListener {
    private lateinit var binding: ActivitySettingEmojiBinding
    private val viewModel: SettingEmojiViewModel by viewModel()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_setting_emoji)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        viewModel.settingEmojiListener = this



        binding.btnBack.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v){
            binding.btnBack -> onBackPressed()
        }
    }
}

