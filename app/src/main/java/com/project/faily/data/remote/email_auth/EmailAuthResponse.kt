package com.project.faily.data.remote.email_auth




data class SendEmailResponse(
    val isSuccess:Boolean,
    val code: Int,
    val message: String,
    val VerificationCode: Int)


