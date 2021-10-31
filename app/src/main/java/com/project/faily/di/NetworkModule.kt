package com.project.faily.di


import com.project.faily.data.remote.answer.AnswerService
import com.project.faily.data.remote.calendar.CalendarService
import com.project.faily.data.remote.chat.ChatService
import com.project.faily.data.remote.email_auth.EmailAuthService
import com.project.faily.data.remote.home.HomeService
import com.project.faily.data.remote.login.LoginService
import com.project.faily.data.remote.question.QuestionService
import com.project.faily.data.remote.qustion_all.QuestionAllService
import com.project.faily.data.remote.schedule_add.ScheduleAddService
import com.project.faily.data.remote.tutorial_insert.TutorialInsertService
import com.project.faily.data.remote.tutorial_invite.TutorialInviteService
import com.project.faily.util.SharedPreferencesManager
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import org.koin.core.module.Module
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


const val PRODUCTION_URL = "http://13.209.10.30:3000/"
const val TEST_URL = "http://3.34.242.198:8080/"
private val base_url: String = TEST_URL

fun getBaseUrl() = base_url

val networkModule: Module = module {
    fun provideHeaderInterceptor(sharedPreferenceManager: SharedPreferencesManager) =
        Interceptor { chain ->
            val request = chain.request().newBuilder()
                .addHeader("jwt_token", sharedPreferenceManager.getJwtToken())
                .build()

            chain.proceed(request)
        }
    fun provideOkHttpClient(
        headerInterceptor: Interceptor
    ) = OkHttpClient.Builder()
        .readTimeout(5000, TimeUnit.MILLISECONDS)
        .connectTimeout(5000, TimeUnit.MILLISECONDS)
        .addInterceptor(headerInterceptor)
        .build()

    fun provideRetrofit(okHttpClient: OkHttpClient):Retrofit = Retrofit.Builder()
        .baseUrl(getBaseUrl())
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttpClient)
        .build()


    fun provideEmailAuthService(retrofit: Retrofit): EmailAuthService =
        retrofit.create(EmailAuthService::class.java)

    fun provideLoginService(retrofit: Retrofit): LoginService =
        retrofit.create(LoginService::class.java)
    fun provideTutorialInsertService(retrofit: Retrofit): TutorialInsertService =
        retrofit.create(TutorialInsertService::class.java)
    fun provideTutorialInviteService(retrofit: Retrofit): TutorialInviteService =
        retrofit.create(TutorialInviteService::class.java)
    fun provideHomeService(retrofit: Retrofit): HomeService =
        retrofit.create(HomeService::class.java)
    fun provideQuestionService(retrofit: Retrofit): QuestionService =
        retrofit.create(QuestionService::class.java)
    fun provideQuestionAllService(retrofit: Retrofit): QuestionAllService =
        retrofit.create(QuestionAllService::class.java)
    fun provideAnswerService(retrofit: Retrofit): AnswerService =
        retrofit.create(AnswerService::class.java)
    fun provideScheduleAddService(retrofit: Retrofit): ScheduleAddService =
        retrofit.create(ScheduleAddService::class.java)
    fun provideCalendarService(retrofit: Retrofit): CalendarService =
        retrofit.create(CalendarService::class.java)
    fun provideChatService(retrofit: Retrofit): ChatService =
        retrofit.create(ChatService::class.java)

    single { provideHeaderInterceptor(get()) }
    single { provideOkHttpClient(get()) }
    single { provideRetrofit(get()) }

    single { provideEmailAuthService(get()) }
    single { provideLoginService(get()) }
    single { provideTutorialInsertService(get()) }
    single { provideTutorialInviteService(get()) }
    single { provideHomeService(get()) }
    single { provideQuestionService(get()) }
    single { provideQuestionAllService(get()) }
    single { provideAnswerService(get()) }
    single { provideScheduleAddService(get()) }
    single { provideCalendarService(get()) }
    single { provideChatService(get()) }

}

