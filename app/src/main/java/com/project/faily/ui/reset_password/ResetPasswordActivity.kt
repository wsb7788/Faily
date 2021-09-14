package com.project.faily.ui.reset_password

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.project.faily.R
import com.project.faily.data.remote.login.LoginListener
import com.project.faily.data.remote.reset_password.ResetPasswordListener
import com.project.faily.data.remote.sign_in.SignInListener
import com.project.faily.data.remote.sign_up.SignUpListener
import com.project.faily.databinding.ActivityResetPasswordBinding
import com.project.faily.databinding.ActivitySignInBinding
import com.project.faily.databinding.ActivitySignUpBinding
import com.project.faily.ui.BaseActivity
import com.project.faily.ui.sign_up.SignUpViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class ResetPasswordActivity : BaseActivity(), ResetPasswordListener {
    private lateinit var binding: ActivityResetPasswordBinding
    private val viewModel: SignUpViewModel by viewModel()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_reset_password)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        viewModel.resetPasswordListener = this


    }


}