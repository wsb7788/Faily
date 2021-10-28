package com.project.faily.data.remote.schedule_add

import com.project.faily.data.entities.Answer
import com.project.faily.data.entities.Schedule
import java.util.*
import kotlin.collections.ArrayList


data class AddCalendarResponse(
    val isSuccess:Boolean,
    val code: Int,
    val message: String,
    val calendar: Schedule)



