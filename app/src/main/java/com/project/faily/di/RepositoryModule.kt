package com.project.faily.di

import com.project.faily.data.repository.sign_up2.SignUp2Repository
import org.koin.dsl.module

val repositoryModule = module {

    single { SignUp2Repository(get()) }
}