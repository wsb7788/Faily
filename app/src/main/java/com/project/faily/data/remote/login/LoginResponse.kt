package com.project.faily.data.remote.login




data class LoginResponse(
    val isSuccess:Boolean,
    val code: Int,
    val message: String,
    val jwt_token: String)


