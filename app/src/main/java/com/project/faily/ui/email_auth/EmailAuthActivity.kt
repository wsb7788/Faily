package com.project.faily.ui.email_auth

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.project.faily.R
import com.project.faily.data.remote.email_auth.EmailAuthListener
import com.project.faily.data.remote.login.LoginListener
import com.project.faily.data.remote.sign_up.SignUpListener
import com.project.faily.databinding.ActivityEmailAuthBinding
import com.project.faily.databinding.ActivitySignUpBinding
import com.project.faily.ui.BaseActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class EmailAuthActivity : BaseActivity(), EmailAuthListener {
    private lateinit var binding: ActivityEmailAuthBinding
    private val viewModel: EmailAuthViewModel by viewModel()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_email_auth)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        viewModel.emailAuthListener = this


    }


}