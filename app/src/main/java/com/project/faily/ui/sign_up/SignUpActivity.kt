package com.project.faily.ui.sign_up

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.project.faily.R
import com.project.faily.data.remote.login.LoginListener
import com.project.faily.data.remote.sign_up.SignUpListener
import com.project.faily.databinding.ActivitySignUpBinding
import com.project.faily.ui.BaseActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class SignUpActivity : BaseActivity(), SignUpListener {
    private lateinit var binding: ActivitySignUpBinding
    private val viewModel: SignUpViewModel by viewModel()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_sign_up)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        viewModel.signUpListener = this


    }


}