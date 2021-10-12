package com.project.faily.ui.tutorial_invite

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.project.faily.R
import com.project.faily.data.remote.tutorial_invite.TutorialInviteListener
import com.project.faily.databinding.ActivityTutorialInviteBinding
import com.project.faily.ui.BaseActivity
import com.project.faily.ui.main.MainActivity
import com.project.faily.util.toast
import org.koin.androidx.viewmodel.ext.android.viewModel

class TutorialInviteActivity : BaseActivity(), TutorialInviteListener {
    private lateinit var binding: ActivityTutorialInviteBinding
    private val viewModel: TutorialInviteViewModel by viewModel()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_tutorial_invite)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        viewModel.tutorialInviteListener = this





        viewModel.codeLoad()

        binding.button.setOnClickListener(this)
        binding.btnBack.setOnClickListener(this)
    }

    override fun onClick(v: View?) {

        when(v){
            binding.btnBack -> onBackPressed()
            binding.button -> viewModel.saveChatCode()
        }
    }

    override fun onLoadFailure(message: String) {
        applicationContext.toast(message)
    }

    override fun onLoadSuccess(code: String) {
        binding.tvCode.text = code
    }

    override fun onStartMain() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }


}