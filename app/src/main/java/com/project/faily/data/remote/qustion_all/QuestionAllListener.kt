package com.project.faily.data.remote.qustion_all

import com.project.faily.data.entities.Answer

interface QuestionAllListener {
    fun onLoadSuccess(result: ArrayList<Answer>)
    fun onLoadFailure(message: String)


}