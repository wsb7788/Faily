package com.project.faily.ui.email_auth

import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.project.faily.R
import com.project.faily.data.remote.email_auth.EmailAuthListener
import com.project.faily.data.remote.login.LoginListener
import com.project.faily.data.remote.sign_up.SignUpListener
import com.project.faily.databinding.ActivityEmailAuthBinding
import com.project.faily.databinding.ActivitySignUpBinding
import com.project.faily.ui.BaseActivity
import com.project.faily.ui.sign_up.SignUpViewModel
import com.project.faily.ui.sign_up2.SignUp2ViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class EmailAuthActivity : BaseActivity(), EmailAuthListener {
    private lateinit var binding: ActivityEmailAuthBinding
    private val viewModel: SignUp2ViewModel by viewModel()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_email_auth)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        viewModel.emailAuthListener = this

        viewModel.emailAuth()


    }

    override fun onLoginSucess(message: String) {
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show()
    }

    override fun onLoginFailure(message: String) {
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show()
    }


}