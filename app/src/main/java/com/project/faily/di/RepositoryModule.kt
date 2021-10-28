package com.project.faily.di

import com.project.faily.data.repository.answer.AnswerRepository
import com.project.faily.data.repository.email_auth.EmailAuthRepository
import com.project.faily.data.repository.home.HomeRepository
import com.project.faily.data.repository.login.LoginRepository
import com.project.faily.data.repository.question.QuestionRepository
import com.project.faily.data.repository.question_all.QuestionAllRepository
import com.project.faily.data.repository.tutorial_insert.TutorialInsertRepository
import com.project.faily.data.repository.tutorial_invite.TutorialInviteRepository
import org.koin.dsl.module

val repositoryModule = module {

    single { EmailAuthRepository(get()) }
    single { LoginRepository(get()) }
    single { TutorialInsertRepository(get()) }
    single { TutorialInviteRepository(get()) }
    single { HomeRepository(get()) }
    single { QuestionRepository(get()) }
    single { QuestionAllRepository(get()) }
    single { AnswerRepository(get()) }
}