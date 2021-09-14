package com.project.faily.ui.permission

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.project.faily.R
import com.project.faily.data.remote.login.LoginListener
import com.project.faily.data.remote.permission.PermissionListener
import com.project.faily.data.remote.reset_password.ResetPasswordListener
import com.project.faily.data.remote.sign_in.SignInListener
import com.project.faily.data.remote.sign_up.SignUpListener
import com.project.faily.databinding.ActivityPermissionBinding
import com.project.faily.databinding.ActivityResetPasswordBinding
import com.project.faily.databinding.ActivitySignInBinding
import com.project.faily.databinding.ActivitySignUpBinding
import com.project.faily.ui.BaseActivity
import com.project.faily.ui.sign_up.SignUpViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class PermissionActivity : BaseActivity(), PermissionListener {
    private lateinit var binding: ActivityPermissionBinding
    private val viewModel: PermissionViewModel by viewModel()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_permission)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        viewModel.permissionListener = this


    }


}