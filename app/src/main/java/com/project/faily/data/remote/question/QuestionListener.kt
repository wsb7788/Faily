package com.project.faily.data.remote.question

import com.project.faily.data.entities.Answer

interface QuestionListener {
    fun onLoadFailure(message: String)
    fun onLoadSuccess(result: ArrayList<Answer>)


}