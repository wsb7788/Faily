package com.project.faily.ui.tutorial_insert

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.project.faily.R
import com.project.faily.data.remote.email_auth.EmailAuthListener
import com.project.faily.data.remote.tutorial_insert.TutorialInsertListener
import com.project.faily.databinding.ActivityEmailAuthBinding
import com.project.faily.databinding.ActivityTutorialInsertBinding
import com.project.faily.ui.BaseActivity
import com.project.faily.ui.email_auth.EmailAuthViewModel
import com.project.faily.ui.tutorial.TutorialActivity
import com.project.faily.util.hideKeyboard
import com.project.faily.util.toast
import org.koin.androidx.viewmodel.ext.android.viewModel

class TutorialInsertActivity : BaseActivity(), TutorialInsertListener {
    private lateinit var binding: ActivityTutorialInsertBinding
    private val viewModel: TutorialInsertViewModel by viewModel()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_tutorial_insert)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        viewModel.tutorialInsertListener = this



        observeCode()

        binding.button.setOnClickListener(this)
        binding.btnBack.setOnClickListener(this)

    }

    override fun onClick(v: View?) {

        when(v){
            binding.button ->viewModel.checkInviteCode()
            binding.btnBack -> onBackPressed()
        }
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

    override fun onCheckFailure(message: String) {
        applicationContext.toast(message)
    }


}