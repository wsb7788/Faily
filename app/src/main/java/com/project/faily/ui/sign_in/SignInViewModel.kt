package com.project.faily.ui.sign_in





import android.text.SpannableStringBuilder
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.project.faily.data.remote.sign_in.SignInListener

class SignInViewModel: ViewModel(){


    var signinListener: SignInListener? = null

    val id: MutableLiveData<String> by lazy {
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
        if(!id.value.isNullOrEmpty()){
            val editable = SpannableStringBuilder("")
            signinListener!!.clearEmail(editable)
        }

    }
}