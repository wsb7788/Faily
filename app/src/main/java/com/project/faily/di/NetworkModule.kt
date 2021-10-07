package com.project.faily.di


import com.project.faily.data.remote.email_auth.EmailAuthService
import com.project.faily.data.remote.login.LoginService
import com.project.faily.data.remote.tutorial_insert.TutorialInsertService
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

    single { provideHeaderInterceptor(get()) }
    single { provideOkHttpClient(get()) }
    single { provideRetrofit(get()) }
    single { provideEmailAuthService(get()) }
    single { provideLoginService(get()) }
    single { provideTutorialInsertService(get()) }

}

