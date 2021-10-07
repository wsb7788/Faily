package com.project.faily.ui.sign_in





import android.text.SpannableStringBuilder
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.project.faily.data.entities.User
import com.project.faily.data.remote.sign_in.SignInListener
import com.project.faily.data.repository.login.LoginRepository
import com.project.faily.util.Coroutines
import com.project.faily.util.SharedPreferencesManager
import java.util.regex.Pattern

class SignInViewModel(private val repository: LoginRepository, private val sharedPreferencesManager: SharedPreferencesManager): ViewModel(){


    var signinListener: SignInListener? = null

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

    fun showPw(){
        showPw.postValue(!showPw.value!!)
    }

    fun emailBlankCheck() {
        if(!email.value.isNullOrEmpty()){
            val editable = SpannableStringBuilder("")
            signinListener!!.clearEmail(editable)
        }

    }

    fun checkUser() {
        val _email = email.value.toString()
        val _pw = pw.value.toString()

        if(_email.isEmpty()){
            signinListener!!.onCheckUserFailure( "이메일 주소를 입력해주세요.")
            return
        }

        if(!Pattern.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.0-]+\\.[a-zA-Z]{2,6}\$", _email)){
            signinListener!!.onCheckUserFailure( "정확한 이메일 주소를 입력해주세요.")
            return
        }

        if(_pw.isEmpty()){
            signinListener!!.onCheckUserFailure( "비밀번호를 입력해주세요.")
            return
        }

        startLogin()
    }

    private fun startLogin() {

        Coroutines.main {

            try {
                val email = email.value.toString()
                val pw = pw.value.toString()

                val loginResponse = repository.login(User(user_email = email, user_pw = pw))

                if(loginResponse.isSuccess){
                    sharedPreferencesManager.saveJwtToken(loginResponse.jwt_token)
                    signinListener!!.onLoginSuccess()
                    return@main
                }
                signinListener!!.onLoginFailure(loginResponse.message)



            }catch (e:Exception){
                signinListener!!.onLoginFailure(e.message!!)
            }
        }
    }
}