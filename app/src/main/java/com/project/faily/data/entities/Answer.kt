package com.project.faily.data.entities

data class Answer(
    val date: String,
    val question: String,
    val isAnswered: Boolean,
    val allAnswered: Boolean,
    val question_Index: Int,
    val answerInfo:ArrayList<AnswerInfo>
)
data class AnswerInfo(
    val user_name: String,
    val user_image: String,
    val answer: String,
    val answer_date: String
)