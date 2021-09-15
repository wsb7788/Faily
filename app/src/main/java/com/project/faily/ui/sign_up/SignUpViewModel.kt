package com.project.faily.ui.sign_up





import android.text.SpannableStringBuilder
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.project.faily.data.BaseRepository
import com.project.faily.data.remote.email_auth.EmailAuthListener
import com.project.faily.data.remote.login.LoginListener
import com.project.faily.data.remote.reset_password.ResetPasswordListener
import com.project.faily.data.remote.reset_password2.ResetPassword2Listener
import com.project.faily.data.remote.sign_up.SignUpListener
import com.project.faily.data.remote.splash.SplashListener
import java.util.regex.Pattern

class SignUpViewModel: ViewModel(){
    var signUpListener: SignUpListener? = null
    var resetPasswordListener:ResetPasswordListener? = null
    var emailAuthListener:EmailAuthListener? = null
    var resetPassword2Listener : ResetPassword2Listener? = null


    val email: MutableLiveData<String> by lazy {
        MutableLiveData<String>().apply {
            postValue("")
        }
    }

    val pw: MutableLiveData<String> by lazy {
        MutableLiveData<String>().apply {
            postValue("")
        }
    }

    val pwCheck: MutableLiveData<String> by lazy {
        MutableLiveData<String>().apply {
            postValue("")
        }
    }
    val showPw: MutableLiveData<Boolean> by lazy {
        MutableLiveData<Boolean>().apply {
            postValue(false)
        }
    }
    val showPwCheck: MutableLiveData<Boolean> by lazy {
        MutableLiveData<Boolean>().apply {
            postValue(false)
        }
    }
    val allAgree: MutableLiveData<Boolean> by lazy {
        MutableLiveData<Boolean>().apply {
            postValue(false)
        }
    }
    val personalAgree: MutableLiveData<Boolean> by lazy {
        MutableLiveData<Boolean>().apply {
            postValue(false)
        }
    }
    val serviceAgree: MutableLiveData<Boolean> by lazy {
        MutableLiveData<Boolean>().apply {
            postValue(false)
        }
    }

    fun showPw(){
        showPw.postValue(!showPw.value!!)
    }
    fun showPwCheck(){
        showPwCheck.postValue(!showPwCheck.value!!)
    }

    fun emailBlankCheck() {
        if(!email.value.isNullOrEmpty()){
            val editable = SpannableStringBuilder("")
            signUpListener!!.clearEmail(editable)
        }

    }

    fun checkUser() {
        val _email = email.value.toString()
        val _pw = pw.value.toString()

        if(_email.isEmpty()){
            signUpListener!!.onCheckUserFailure( "이메일 주소를 입력해주세요.")
            return
        }

        if(!Pattern.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.0-]+\\.[a-zA-Z]{2,6}\$", _email)){
            signUpListener!!.onCheckUserFailure( "정확한 이메일 주소를 입력해주세요.")
            return
        }

        if(_pw.isEmpty()){
            signUpListener!!.onCheckUserFailure( "비밀번호를 입력해주세요.")
            return
        }
    }
}