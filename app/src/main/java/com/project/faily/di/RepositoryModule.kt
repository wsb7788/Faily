package com.project.faily.di

import com.project.faily.data.repository.email_auth.EmailAuthRepository
import org.koin.dsl.module

val repositoryModule = module {

    single { EmailAuthRepository(get()) }
}