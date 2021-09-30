package com.project.faily.ui.login

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.project.faily.R
import com.project.faily.data.remote.login.LoginListener
import com.project.faily.databinding.ActivityLoginBinding
import com.project.faily.ui.BaseActivity
import com.project.faily.ui.sign_in.SignInActivity
import com.project.faily.ui.sign_up.SignUpActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginActivity: BaseActivity(),LoginListener{
    private lateinit var binding: ActivityLoginBinding
    private val viewModel: LoginViewModel by viewModel()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        viewModel.loginListener = this


        binding.btnSignUp.setOnClickListener(this)
        binding.btnSignIn.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v){
            binding.btnSignIn -> onStartSignIn()
            binding.btnSignUp -> onStartSignUp()
        }
    }

    private fun onStartSignUp() {
        val intent = Intent(this, SignUpActivity::class.java)
        startActivity(intent)
    }
    private fun onStartSignIn() {
        val intent = Intent(this, SignInActivity::class.java)
        startActivity(intent)
    }
}