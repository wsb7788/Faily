package com.project.faily.di

import com.project.faily.ui.answer.AnswerViewModel
import com.project.faily.ui.calendar.CalendarViewModel
import com.project.faily.ui.gallery.GalleryViewModel
import com.project.faily.ui.home.HomeViewModel
import com.project.faily.ui.login.LoginViewModel
import com.project.faily.ui.main.MainViewModel
import com.project.faily.ui.permission.PermissionViewModel
import com.project.faily.ui.question.QuestionViewModel
import com.project.faily.ui.schedule_add.ScheduleAddViewModel
import com.project.faily.ui.setting.SettingViewModel
import com.project.faily.ui.sign_in.SignInViewModel
import com.project.faily.ui.sign_up.SignUpViewModel
import com.project.faily.ui.sign_up2.SignUp2ViewModel
import com.project.faily.ui.splash.SplashViewModel
import org.koin.androidx.viewmodel.dsl.viewModel

import org.koin.dsl.module


val viewModelModule = module {
    viewModel { LoginViewModel() }
    viewModel { SplashViewModel() }
    viewModel { SignUpViewModel() }
    viewModel { SignInViewModel() }
    viewModel { PermissionViewModel() }
    viewModel { SignUp2ViewModel(get(), get()) }
    viewModel { HomeViewModel() }
    viewModel { MainViewModel() }
    viewModel { CalendarViewModel() }
    viewModel { QuestionViewModel() }
    viewModel { SettingViewModel() }
    viewModel { GalleryViewModel() }
    viewModel { ScheduleAddViewModel() }
    viewModel { AnswerViewModel() }
}