
package com.project.faily.ui.email_auth




import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.project.faily.data.entities.User
import com.project.faily.data.remote.email_auth.EmailAuthListener
import com.project.faily.data.repository.email_auth.EmailAuthRepository
import com.project.faily.util.Coroutines
import com.project.faily.util.SharedPreferencesManager

class EmailAuthViewModel(private val repository: EmailAuthRepository, private val sharedPreferencesManager: SharedPreferencesManager): ViewModel(){

    var emailAuthListener:EmailAuthListener? = null


    val code1: MutableLiveData<String> by lazy {
        MutableLiveData<String>().apply {
            postValue("")
        }
    }
    val code2: MutableLiveData<String> by lazy {
        MutableLiveData<String>().apply {
            postValue("")
        }
    }
    val code3: MutableLiveData<String> by lazy {
        MutableLiveData<String>().apply {
            postValue("")
        }
    }
    val code4: MutableLiveData<String> by lazy {
        MutableLiveData<String>().apply {
            postValue("")
        }
    }

    fun sendEmail() {
        val email = sharedPreferencesManager.getSignUpEmail()
        val user = User(user_email = email)


        Coroutines.main {
            try{
                val emailAuthResponse = repository.sendEmail(user)
                if (emailAuthResponse.isSuccess) {
                    sharedPreferencesManager.saveSignUpCode(emailAuthResponse.VerificationCode)
                    return@main
                }
                emailAuthListener!!.onSendFailure(emailAuthResponse.message)
            }catch (e:Exception){
                Log.d("로그",e.message!!)
                emailAuthListener!!.onSendFailure(e.message!!)
            }
        }
    }

    fun checkCode() {
        val authCode = sharedPreferencesManager.getSignUpCode()
        val code = code1.value + code2.value +code3.value +code4.value

        if(authCode == code){
            signUp()
            return
        }
        emailAuthListener!!.onAuthFailure("코드가 일치하지 않습니다.")
    }

    private fun signUp() {
        val email = sharedPreferencesManager.getSignUpEmail()
        val pw = sharedPreferencesManager.getSignUpPassword()
        val bdate = sharedPreferencesManager.getSignUpBdate()
        val name = sharedPreferencesManager.getSignUpName()
        val user = User(user_email = email,user_bdate = bdate,user_name = name,user_pw = pw)

        Coroutines.main {
            try {
                val response = repository.joinDo(user)

                if(response.isSuccess) {
                    emailAuthListener!!.onStartTutorial()
                    return@main
                }
                emailAuthListener!!.onJoinFailure(response.message)
            }catch (e:Exception){
                emailAuthListener!!.onJoinFailure(e.message!!)
            }
        }
    }


}
