package com.project.faily.data.remote.tutorial_insert

interface TutorialInsertListener {

    fun observeCode()
    fun onCheckFailure(message: String)
    fun onCheckSuccess(message: String)
    fun onStartMain()


}