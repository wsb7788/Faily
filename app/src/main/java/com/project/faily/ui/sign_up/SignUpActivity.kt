package com.project.faily.ui.sign_up

import android.os.Bundle
import android.text.InputType
import android.text.SpannableStringBuilder
import android.view.View
import android.widget.CheckBox
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.project.faily.R
import com.project.faily.data.remote.login.LoginListener
import com.project.faily.data.remote.sign_up.SignUpListener
import com.project.faily.databinding.ActivitySignUpBinding
import com.project.faily.ui.BaseActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class SignUpActivity : BaseActivity(), SignUpListener {
    private lateinit var binding: ActivitySignUpBinding
    private val viewModel: SignUpViewModel by viewModel()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_sign_up)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        viewModel.signUpListener = this


        idObserve()
        pwShowObserve()
        pwShowCheckObserve()

        binding.btnSeePersonal.setOnClickListener(this)
        binding.btnSeeService.setOnClickListener(this)
        binding.button.setOnClickListener(this)
        binding.ivPasswordCheck.setOnClickListener(this)
        binding.ivPassword.setOnClickListener(this)
        binding.ivEmail.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        when(v) {
            binding.ivEmail -> viewModel.emailBlankCheck()
            binding.ivPassword -> viewModel.showPw()
            binding.ivPasswordCheck -> viewModel.showPwCheck()
            binding.button -> viewModel.checkUser()
            binding.btnSeePersonal -> {
            }
            binding.btnSeeService -> {
            }
        }
    }

    private fun idObserve() {
        viewModel.email.observe(this,{
            if(viewModel.email.value.isNullOrEmpty()){
                binding.ivEmail.setImageResource(R.drawable.ic_email_delete_off)
                return@observe
            }
            binding.ivEmail.setImageResource(R.drawable.ic_email_delete_on)
        })
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

    }
    private fun pwShowCheckObserve() {
        viewModel.showPwCheck.observe(this, {
            if(viewModel.showPwCheck.value!!){
                binding.ivPasswordCheck.setImageResource(R.drawable.ic_password_see_on)
                binding.etPasswordCheck.inputType = InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD
                return@observe
            }
            binding.ivPasswordCheck.setImageResource(R.drawable.ic_password_see_off)
            binding.etPasswordCheck.inputType = InputType.TYPE_TEXT_VARIATION_PASSWORD or InputType.TYPE_CLASS_TEXT
        })

    }

    override fun clearEmail(editable: SpannableStringBuilder) {
        binding.etEmail.text = editable
    }

    override fun onCheckUserFailure(message: String) {
        Toast.makeText(applicationContext, message, Toast.LENGTH_SHORT).show()
    }
    fun onAgreeClicked(view: View){
        when(view as CheckBox){
            binding.cbCheckAll ->  {
                if(binding.cbCheckAll.isChecked){
                    binding.cbCheckAll.setBackgroundResource(R.drawable.ic_checked_box)
                    binding.cbPersonal.setBackgroundResource(R.drawable.ic_checked)
                    binding.cbService.setBackgroundResource(R.drawable.ic_checked)
                    binding.cbPersonal.isChecked = true
                    binding.cbService.isChecked = true
                    return
                }
                binding.cbCheckAll.setBackgroundResource(R.drawable.ic_unchecked_box)
                binding.cbPersonal.setBackgroundResource(R.drawable.ic_unchecked)
                binding.cbService.setBackgroundResource(R.drawable.ic_unchecked)
                binding.cbPersonal.isChecked = false
                binding.cbService.isChecked = false

            }
            binding.cbPersonal ->  {
                if(binding.cbPersonal.isChecked){
                    binding.cbPersonal.setBackgroundResource(R.drawable.ic_checked)
                    if(binding.cbService.isChecked){
                        binding.cbCheckAll.setBackgroundResource(R.drawable.ic_checked_box)
                        binding.cbCheckAll.isChecked = true
                    }
                    return
                }
                binding.cbPersonal.setBackgroundResource(R.drawable.ic_unchecked)
                binding.cbCheckAll.setBackgroundResource(R.drawable.ic_unchecked_box)
                binding.cbCheckAll.isChecked = false
            }
            binding.cbService ->  {
                if(binding.cbService.isChecked){
                    binding.cbService.setBackgroundResource(R.drawable.ic_checked)
                    if(binding.cbPersonal.isChecked){
                        binding.cbCheckAll.setBackgroundResource(R.drawable.ic_checked_box)
                        binding.cbCheckAll.isChecked = true
                    }
                    return
                }
                binding.cbService.setBackgroundResource(R.drawable.ic_unchecked)
                binding.cbCheckAll.setBackgroundResource(R.drawable.ic_unchecked_box)
                binding.cbCheckAll.isChecked = false

            }


        }

    }

}

