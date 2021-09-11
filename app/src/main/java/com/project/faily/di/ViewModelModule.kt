package com.project.faily.di

import com.project.faily.ui.login.LoginViewModel
import org.koin.androidx.viewmodel.dsl.viewModel

import org.koin.dsl.module


val viewModelModule = module {
    viewModel { LoginViewModel() }
}