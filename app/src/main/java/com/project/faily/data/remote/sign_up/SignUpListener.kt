package com.project.faily.data.remote.sign_up

import android.text.SpannableStringBuilder

interface SignUpListener {
    fun clearName(editable: SpannableStringBuilder)
    fun onCheckUserFailure( message: String)
    fun onStartSignUp2()

}