package com.project.faily.data.remote.tutorial_invite

interface TutorialInviteListener {
    fun onLoadFailure(message: String)
    fun onLoadSuccess(code: String)


}