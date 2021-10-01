package com.project.faily.ui.email_auth

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.project.faily.R
import com.project.faily.data.remote.email_auth.EmailAuthListener
import com.project.faily.databinding.ActivityEmailAuthBinding
import com.project.faily.ui.BaseActivity
import com.project.faily.ui.tutorial.TutorialActivity
import com.project.faily.util.hideKeyboard
import com.project.faily.util.toast
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

        viewModel.sendEmail()

        observeCode()

        binding.button.setOnClickListener(this)
        binding.btnBack.setOnClickListener(this)

    }

    override fun onClick(v: View?) {

        when(v){
            binding.button ->viewModel.checkCode()
            binding.btnBack -> onBackPressed()
        }
    }

    override fun onSendFailure(message: String) {
        applicationContext.toast(message)
    }

    override fun observeCode() {
        viewModel.code1.observe(this,{
            if(binding.etEmailCode1.text.isNotEmpty()){
                binding.etEmailCode2.requestFocus()
            }
        })
        viewModel.code2.observe(this,{
            if(binding.etEmailCode2.text.isNotEmpty()){
                binding.etEmailCode3.requestFocus()
            }
        })
        viewModel.code3.observe(this,{
            if(binding.etEmailCode3.text.isNotEmpty()){
                binding.etEmailCode4.requestFocus()
            }
        })
        viewModel.code4.observe(this,{
            if(binding.etEmailCode3.text.isNotEmpty()){
                binding.root.hideKeyboard()
            }
        })
    }

    override fun onAuthFailure(message: String) {
        applicationContext.toast(message)
    }

    override fun onJoinFailure(message: String) {
        applicationContext.toast(message)
    }

    override fun onStartTutorial() {
        val intent = Intent(this,TutorialActivity::class.java)
        startActivity(intent)
        finish()
    }


}