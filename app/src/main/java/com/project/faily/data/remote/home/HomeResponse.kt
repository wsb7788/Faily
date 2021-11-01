package com.project.faily.data.remote.home




data class TodayQuestionResponse(
    val isSuccess:Boolean,
    val code: Int,
    val message: String,
    val todayQuestion: String)

data class LoginResponse(
    val isSuccess:Boolean,
    val code: Int,
    val message: String,
    val jwt_token: String,
    val group_code: String)

data class HomeResponse(
    val isSuccess:Boolean,
    val code: Int,
    val message: String,
    val result: ArrayList<HomeInfo>)

data class HomeInfo(
    val user_mood: String,
    val familyList: ArrayList<FamilyList>,
    val today_anniversary:String,
    val today: String,
    val user_name:String
)

data class FamilyList(
    val user_name: String,
    val user_bonding:Float,
    val user_image: String,
    val user_mood: String
)
