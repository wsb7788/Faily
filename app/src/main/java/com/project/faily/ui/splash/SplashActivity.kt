package com.project.faily.ui.splash

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.project.faily.R
import com.project.faily.data.remote.login.LoginListener
import com.project.faily.data.remote.splash.SplashListener
import com.project.faily.databinding.ActivitySplashBinding
import com.project.faily.ui.BaseActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class SplashActivity: BaseActivity(),SplashListener{
    private lateinit var binding: ActivitySplashBinding
    private val viewModel: SplashViewModel by viewModel()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_splash)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        viewModel.splashListener = this



    }


}