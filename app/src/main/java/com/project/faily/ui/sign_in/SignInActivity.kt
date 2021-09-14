package com.project.faily.ui.sign_in

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.project.faily.R
import com.project.faily.data.remote.login.LoginListener
import com.project.faily.data.remote.sign_in.SignInListener
import com.project.faily.data.remote.sign_up.SignUpListener
import com.project.faily.databinding.ActivitySignInBinding
import com.project.faily.databinding.ActivitySignUpBinding
import com.project.faily.ui.BaseActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class SignInActivity : BaseActivity(), SignInListener {
    private lateinit var binding: ActivitySignInBinding
    private val viewModel: SignInViewModel by viewModel()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_sign_in)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        viewModel.signinListener = this


    }


}