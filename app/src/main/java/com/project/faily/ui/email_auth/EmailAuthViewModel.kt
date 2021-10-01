
package com.project.faily.ui.email_auth




import android.text.SpannableStringBuilder
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.project.faily.data.entities.Email
import com.project.faily.data.remote.email_auth.EmailAuthListener
import com.project.faily.data.remote.reset_password.ResetPasswordListener
import com.project.faily.data.remote.reset_password2.ResetPassword2Listener
import com.project.faily.data.remote.sign_up.SignUpListener
import com.project.faily.data.remote.sign_up2.SignUp2Listener
import com.project.faily.data.repository.email_auth.EmailAuthRepository
import com.project.faily.util.Coroutines
import com.project.faily.util.SharedPreferencesManager
import java.util.regex.Pattern

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
        val email = Email(sharedPreferencesManager.getSignUpEmail())


        Coroutines.main {
            try{
                val emailAuthResponse = repository.sendEmail(email)
                if (emailAuthResponse.isSuccess) {
                    emailAuthListener!!.onLoginSucess(emailAuthResponse.message)
                    return@main
                }
                emailAuthListener!!.onLoginFailure(emailAuthResponse.message)
            }catch (e:Exception){
                Log.d("로그",e.message!!)
                emailAuthListener!!.onLoginFailure(e.message!!)
            }


        }

    }


}
