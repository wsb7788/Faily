package com.project.faily.data.remote.qustion_all

import com.project.faily.data.entities.Answer


data class AllQuestionResponse(
    val isSuccess:Boolean,
    val code: Int,
    val message: String,
    val result:ArrayList<Answer>)


