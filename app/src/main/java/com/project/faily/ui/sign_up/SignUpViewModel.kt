package com.project.faily.ui.sign_up





import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.project.faily.data.remote.email_auth.EmailAuthListener
import com.project.faily.data.remote.reset_password.ResetPasswordListener
import com.project.faily.data.remote.reset_password2.ResetPassword2Listener
import com.project.faily.data.remote.sign_up.SignUpListener

class SignUpViewModel: ViewModel(){
    var signUpListener: SignUpListener? = null
    var resetPasswordListener:ResetPasswordListener? = null
    var emailAuthListener:EmailAuthListener? = null
    var resetPassword2Listener : ResetPassword2Listener? = null


    val name: MutableLiveData<String> by lazy {
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


        if(_name.isEmpty()){
            signUpListener!!.onCheckUserFailure( "이름을 입력하세요.")
            return
        }

    }
}