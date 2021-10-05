package com.project.faily.ui.setting_profile

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
import com.project.faily.data.remote.setting_profile.SettingProfileListener
import com.project.faily.data.remote.sign_up.SignUpListener
import com.project.faily.databinding.ActivitySettingProfileBinding
import com.project.faily.databinding.ActivitySignUpBinding
import com.project.faily.databinding.DialogBdateBinding
import com.project.faily.ui.BaseActivity
import com.project.faily.ui.sign_up2.SignUp2Activity
import org.koin.androidx.viewmodel.ext.android.viewModel

class SettingProfileActivity : BaseActivity(), SettingProfileListener {
    private lateinit var binding: ActivitySettingProfileBinding
    private val viewModel: SettingProfileViewModel by viewModel()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_setting_profile)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        viewModel.settingProfileListener = this




    }

}

