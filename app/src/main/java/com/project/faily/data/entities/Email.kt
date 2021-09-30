package com.project.faily.data.entities

import com.google.gson.annotations.SerializedName

data class Email(
    @SerializedName(value = "user_email") val user_email: String = ""
)