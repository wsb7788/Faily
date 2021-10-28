package com.project.faily.data.entities

import com.google.gson.annotations.SerializedName

data class Schedule(
    @SerializedName(value = "calendar_category") val calendar_category: String = "",
    @SerializedName(value = "calendar_name") val calendar_name: String = "",
    @SerializedName(value = "calendar_place") val calendar_place: String = "",
    @SerializedName(value = "calendar_memo") val calendar_memo: String = "",
    @SerializedName(value = "calendar_start_time") val calendar_start_time: String = "",
    @SerializedName(value = "calendar_end_time") val calendar_end_time: String = ""
)