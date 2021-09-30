package com.project.faily.data.remote.email_auth

interface EmailAuthListener {
    fun onLoginSucess(message: String)
    fun onLoginFailure(message: String)


}