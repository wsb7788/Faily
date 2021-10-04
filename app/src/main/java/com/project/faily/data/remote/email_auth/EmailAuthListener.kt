package com.project.faily.data.remote.email_auth

interface EmailAuthListener {
    fun onSendFailure(message:String)
    fun observeCode()
    fun onAuthFailure(message: String)
    fun onJoinFailure(message: String)
    fun onStartTutorial()



}