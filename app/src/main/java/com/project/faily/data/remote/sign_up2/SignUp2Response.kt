package com.project.faily.data.remote.sign_up2




data class SendEmailResponse(
    val isSuccess:Boolean,
    val code: Int,
    val message: String,
    val VerificationCode: Int)


