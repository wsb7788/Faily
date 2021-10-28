package com.project.faily.data.remote.home




data class TodayQuestionResponse(
    val isSuccess:Boolean,
    val code: Int,
    val message: String,
    val todayQuestion: String)

data class LoginResponse(
    val isSuccess:Boolean,
    val code: Int,
    val message: String,
    val jwt_token: String,
    val group_code: String)


