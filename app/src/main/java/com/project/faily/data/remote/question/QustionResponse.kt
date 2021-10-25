package com.project.faily.data.remote.question

import com.project.faily.data.entities.Answer
import java.util.*
import kotlin.collections.ArrayList


data class TodayQuestionResponse(
    val isSuccess:Boolean,
    val code: Int,
    val message: String,
    val todayQuestion: String)

data class AllQuestionResponse(
    val isSuccess:Boolean,
    val code: Int,
    val message: String,
    val result:ArrayList<Answer>)

