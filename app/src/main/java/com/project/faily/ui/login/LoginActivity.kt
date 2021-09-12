package com.project.faily.ui.login

import android.content.ClipData
import android.content.ClipDescription
import android.os.Bundle
import android.util.Log
import android.view.DragEvent
import android.view.MotionEvent
import android.view.View
import android.view.View.INVISIBLE
import android.view.View.VISIBLE
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.project.faily.R
import com.project.faily.data.remote.login.LoginListener
import com.project.faily.databinding.ActivityLoginBinding
import com.project.teamsb.ui.BaseActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginActivity:BaseActivity(),LoginListener{
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