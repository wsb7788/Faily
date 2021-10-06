package com.project.faily.di

import com.project.faily.data.repository.email_auth.EmailAuthRepository
import com.project.faily.data.repository.login.LoginRepository
import org.koin.dsl.module

val repositoryModule = module {

    single { EmailAuthRepository(get()) }
    single { LoginRepository(get()) }
}