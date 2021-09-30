package com.project.faily.data.repository.sign_up2

import com.project.faily.data.remote.sign_up2.SendEmailResponse
import com.project.faily.data.remote.sign_up2.SignUp2Service
import com.project.faily.data.repository.BaseRepository

class SignUp2Repository(private val signUp2Service: SignUp2Service): BaseRepository() {
    suspend fun sendEmail(user_email: String): SendEmailResponse{
        return apiRequest { signUp2Service.sendEmail(user_email) }
    }

}