package com.project.faily.ui.sign_up

import android.content.Intent
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
import com.project.faily.ui.sign_up2.SignUp2Activity
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


        binding.btnSeePersonal.setOnClickListener(this)
        binding.btnSeeService.setOnClickListener(this)
        binding.button.setOnClickListener(this)
        binding.btnBack.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        when(v) {
            binding.button -> viewModel.checkUser()
            binding.btnSeePersonal -> {
            }
            binding.btnSeeService -> {
            }
            binding.btnBack -> onBackPressed()
        }
    }



    override fun clearName(editable: SpannableStringBuilder) {
        binding.etName.text = editable
    }

    override fun onCheckUserFailure(message: String) {
        Toast.makeText(applicationContext, message, Toast.LENGTH_SHORT).show()
    }

    override fun onStartSignUp2() {
        val intent = Intent(this, SignUp2Activity::class.java)
        startActivity(intent)
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

