package com.project.faily.data.entities

import com.google.gson.annotations.SerializedName

data class SendAnswerBody(
    @SerializedName(value = "answer") val group_code: String = "",
    @SerializedName(value = "question_index") val question_index :Int? = null
)