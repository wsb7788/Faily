package com.project.faily.ui.sign_up





import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.project.faily.data.remote.email_auth.EmailAuthListener
import com.project.faily.data.remote.reset_password.ResetPasswordListener
import com.project.faily.data.remote.reset_password2.ResetPassword2Listener
import com.project.faily.data.remote.sign_up.SignUpListener
import com.project.faily.util.SharedPreferencesManager

class SignUpViewModel(private val sharedPreferencesManager: SharedPreferencesManager): ViewModel(){
    var signUpListener: SignUpListener? = null
    var resetPassword2Listener:ResetPassword2Listener?=null
    var resetPasswordListener:ResetPasswordListener?=null


    val name: MutableLiveData<String> by lazy {
        MutableLiveData<String>().apply {
            postValue("")
        }
    }
    val bdate: MutableLiveData<String> by lazy {
        MutableLiveData<String>().apply {
            postValue("")
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




    fun checkUser() {
        val _name = name.value.toString()
        val _personAgree = personalAgree.value
        val _serviceAgree = serviceAgree.value
        val _bdate = bdate.value.toString()
        if(_name.isEmpty()){
            signUpListener!!.onCheckUserFailure( "이름을 입력하세요.")
            return
        }
        if(_bdate.isEmpty()){
            signUpListener!!.onCheckUserFailure("생년월일을 선택해주세요.")
        }
        if(!(_personAgree!! && _serviceAgree!!)){
            signUpListener!!.onCheckUserFailure( "회원가입을 위해서는 이용약관에 모두 동의하셔야 합니다.")
            return
        }
        sharedPreferencesManager.saveSignUpUserInfo(_name,_bdate)
        signUpListener!!.onStartSignUp2()
    }
}