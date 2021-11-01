package com.project.faily.data.remote.setting_emoji

import com.project.faily.data.entities.Answer
import com.project.faily.data.entities.Schedule
import java.util.*
import kotlin.collections.ArrayList


data class EmojisResponse(
    val isSuccess:Boolean,
    val code: Int,
    val message: String,
    val result: ArrayList<Emoji>)

data class Emoji(
    val emoji: String,
    val emoji_id:Int,
    val time:String
)



