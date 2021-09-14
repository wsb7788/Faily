package com.project.faily.ui.reset_password2

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.project.faily.R
import com.project.faily.data.remote.login.LoginListener
import com.project.faily.data.remote.reset_password.ResetPasswordListener
import com.project.faily.data.remote.reset_password2.ResetPassword2Listener
import com.project.faily.data.remote.sign_in.SignInListener
import com.project.faily.data.remote.sign_up.SignUpListener
import com.project.faily.databinding.ActivityResetPassword2Binding
import com.project.faily.databinding.ActivityResetPasswordBinding
import com.project.faily.databinding.ActivitySignInBinding
import com.project.faily.databinding.ActivitySignUpBinding
import com.project.faily.ui.BaseActivity
import com.project.faily.ui.sign_up.SignUpViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class ResetPassword2Activity : BaseActivity(), ResetPassword2Listener {
    private lateinit var binding: ActivityResetPassword2Binding
    private val viewModel: SignUpViewModel by viewModel()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_reset_password2)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        viewModel.resetPassword2Listener = this


    }


}