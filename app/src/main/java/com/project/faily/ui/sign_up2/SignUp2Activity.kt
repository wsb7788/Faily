
package com.project.faily.ui.sign_up2
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
import com.project.faily.data.remote.sign_up2.SignUp2Listener
import com.project.faily.databinding.ActivitySignUp2Binding
import com.project.faily.databinding.ActivitySignUpBinding
import com.project.faily.ui.BaseActivity
import com.project.faily.ui.email_auth.EmailAuthActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class SignUp2Activity : BaseActivity(), SignUp2Listener {
    private lateinit var binding: ActivitySignUp2Binding
    private val viewModel: SignUp2ViewModel by viewModel()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_sign_up2)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        viewModel.signUp2Listener = this


        idObserve()
        pwShowObserve()
        pwShowCheckObserve()


        binding.button.setOnClickListener(this)
        binding.ivPasswordCheck.setOnClickListener(this)
        binding.ivPassword.setOnClickListener(this)
        binding.ivEmail.setOnClickListener(this)
        binding.btnBack.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        when(v) {
            binding.ivEmail -> viewModel.emailBlankCheck()
            binding.ivPassword -> viewModel.showPw()
            binding.ivPasswordCheck -> viewModel.showPwCheck()
            binding.button -> viewModel.checkUser()
            binding.btnBack -> onBackPressed()
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

    override fun onStartEmailAuth() {
        val intent = Intent(this, EmailAuthActivity::class.java)
        startActivity(intent)
    }
}

