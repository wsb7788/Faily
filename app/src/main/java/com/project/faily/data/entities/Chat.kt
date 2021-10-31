package com.project.faily.data.entities

import com.google.gson.annotations.SerializedName

data class Chat(
    @SerializedName(value = "file") val file: String = "",
    @SerializedName(value = "content") val content : String = "",
    @SerializedName(value = "emoji") val emoji : Boolean = false,
    @SerializedName(value = "photo") val photo: Boolean = false,
    @SerializedName(value = "calendar") val calendar : Boolean = false,
    @SerializedName(value = "text") val text : Boolean = false
)