package com.project.faily.data.remote.sign_up

import android.text.SpannableStringBuilder

interface SignUpListener {
    fun clearEmail(editable: SpannableStringBuilder)
    fun onCheckUserFailure( message: String)

}