package com.project.faily.data.remote.sign_in

import android.text.SpannableStringBuilder

interface SignInListener {
    fun clearEmail(editable: SpannableStringBuilder)
    fun onCheckUserFailure( message: String)
    fun onLoginFailure(message: String)
    fun onLoginSuccess()


}