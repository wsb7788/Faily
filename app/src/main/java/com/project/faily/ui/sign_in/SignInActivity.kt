package com.project.faily.ui.sign_in

import android.os.Bundle
import android.text.InputType
import android.text.SpannableStringBuilder
import android.view.View
import androidx.databinding.DataBindingUtil
import com.project.faily.R
import com.project.faily.data.remote.sign_in.SignInListener
import com.project.faily.databinding.ActivitySignInBinding
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

        pwShowObserve()
        binding.ivPassword.setOnClickListener(this)
        binding.ivEmail.setOnClickListener(this)
    }

    private fun pwShowObserve() {
        viewModel.showPw.observe(this, {
            if(viewModel.showPw.value!!){
                binding.ivPassword.setImageResource(R.drawable.ic_password_see_on)
                binding.etPassword.inputType = InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD
                return@observe
            }
            binding.ivPassword.setImageResource(R.drawable.ic_password_see_off)
            binding.etPassword.inputType = InputType.TYPE_TEXT_VARIATION_PASSWORD or InputType.TYPE_CLASS_TEXT
        })
        viewModel.id.observe(this,{
            if(viewModel.id.value.isNullOrEmpty()){
                binding.ivEmail.setImageResource(R.drawable.ic_email_delete_off)
                return@observe
            }
            binding.ivEmail.setImageResource(R.drawable.ic_email_delete_on)
        })
    }

    override fun onClick(v: View?) {
        when(v){
            binding.ivPassword->{
                viewModel.showPw()
            }
            binding.ivEmail ->{
                viewModel.emailBlankCheck()
            }
        }
    }

    override fun clearEmail(editable: SpannableStringBuilder) {
        binding.etEmail.text = editable
    }
}