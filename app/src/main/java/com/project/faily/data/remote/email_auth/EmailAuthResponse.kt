package com.project.faily.data.remote.email_auth




data class SendEmailResponse(
    val isSuccess:Boolean,
    val code: Int,
    val message: String,
    val VerificationCode: String)

data class JoinDoResponse(
    val isSuccess:Boolean,
    val code: Int,
    val message: String,
    val jwt_token: String)


