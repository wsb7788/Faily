package com.project.faily.data.remote.answer

interface AnswerListener {
    fun onFailure(message: String)
    fun onSuccess(message: String)


}