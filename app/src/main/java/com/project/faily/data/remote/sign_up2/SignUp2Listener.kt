package com.project.faily.data.remote.sign_up2

import android.text.SpannableStringBuilder

interface SignUp2Listener {
    fun clearEmail(editable: SpannableStringBuilder)
    fun onCheckUserFailure( message: String)
    fun onStartEmailAuth()

}