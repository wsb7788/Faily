package com.project.faily.di

import com.project.faily.ui.login.LoginViewModel
import com.project.faily.ui.permission.PermissionViewModel
import com.project.faily.ui.sign_in.SignInViewModel
import com.project.faily.ui.sign_up.SignUpViewModel
import com.project.faily.ui.splash.SplashViewModel
import org.koin.androidx.viewmodel.dsl.viewModel

import org.koin.dsl.module


val viewModelModule = module {
    viewModel { LoginViewModel() }
    viewModel { SplashViewModel() }
    viewModel { SignUpViewModel() }
    viewModel { SignInViewModel() }
    viewModel { PermissionViewModel() }
}