package com.project.faily.data.remote.home




data class TodayQuestionResponse(
    val isSuccess:Boolean,
    val code: Int,
    val message: String,
    val todayQuestion: String)


