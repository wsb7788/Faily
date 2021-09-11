package com.project.faily.ui.login

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.project.faily.R
import com.project.faily.data.remote.login.LoginListener
import com.project.faily.databinding.ActivityLoginBinding
import com.project.teamsb.ui.BaseActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginActivity:BaseActivity(),LoginListener {
    private lateinit var binding: ActivityLoginBinding
    private val viewModel: LoginViewModel by viewModel()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        viewModel.loginListener = this
    }
}