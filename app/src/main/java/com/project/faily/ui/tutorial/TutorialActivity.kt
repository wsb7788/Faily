package com.project.faily.ui.tutorial

import android.content.Intent
import android.os.Bundle
import android.view.View
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

        binding.buttonNo.setOnClickListener(this)
        binding.buttonYes.setOnClickListener(this)




    }

    override fun onClick(v: View?) {

        when(v){
            binding.buttonYes -> onStartInsertCode()
            binding.buttonNo -> onStartInviteCode()
        }
    }

    private fun onStartInviteCode() {
        val intent = Intent(this, )
    }

    private fun onStartInsertCode() {

    }
}