
package com.project.faily.ui.sign_up2




import android.text.SpannableStringBuilder
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.project.faily.data.remote.email_auth.EmailAuthListener
import com.project.faily.data.remote.reset_password.ResetPasswordListener
import com.project.faily.data.remote.reset_password2.ResetPassword2Listener
import com.project.faily.data.remote.sign_up.SignUpListener
import com.project.faily.data.remote.sign_up2.SignUp2Listener
import com.project.faily.util.SharedPreferencesManager
import java.util.regex.Pattern

class SignUp2ViewModel(private val sharedPreferencesManager: SharedPreferencesManager): ViewModel(){
    var signUpListener: SignUpListener? = null
    var signUp2Listener: SignUp2Listener? = null
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

    fun showPw(){
        showPw.postValue(!showPw.value!!)
    }
    fun showPwCheck(){
        showPwCheck.postValue(!showPwCheck.value!!)
    }

    fun emailBlankCheck() {
        if(!email.value.isNullOrEmpty()){
            val editable = SpannableStringBuilder("")
            signUp2Listener!!.clearEmail(editable)
        }

    }

    fun checkUser() {
        val _email = email.value.toString()
        val _pw = pw.value.toString()

        if(_email.isEmpty()){
            signUp2Listener!!.onCheckUserFailure( "이메일 주소를 입력해주세요.")
            return
        }

        if(!Pattern.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.0-]+\\.[a-zA-Z]{2,6}\$", _email)){
            signUp2Listener!!.onCheckUserFailure( "정확한 이메일 주소를 입력해주세요.")
            return
        }

        if(_pw.isEmpty()){
            signUp2Listener!!.onCheckUserFailure( "비밀번호를 입력해주세요.")
            return
        }

        sharedPreferencesManager.saveSignUpUserInfo(_email,_pw)
        signUp2Listener!!.onStartEmailAuth()
    }



}
