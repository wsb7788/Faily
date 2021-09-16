package com.project.faily.ui.tutorial

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.project.faily.R
import com.project.faily.data.remote.login.LoginListener
import com.project.faily.data.remote.splash.SplashListener
import com.project.faily.databinding.ActivitySplashBinding
import com.project.faily.databinding.ActivityTutorialBinding
import com.project.faily.ui.BaseActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class TutorialActivity: BaseActivity(){
    private lateinit var binding: ActivityTutorialBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_tutorial)
        binding.lifecycleOwner = this




    }


}