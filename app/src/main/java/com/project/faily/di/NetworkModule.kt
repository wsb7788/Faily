package com.project.faily.di


import com.project.faily.data.remote.sign_up2.SignUp2Service
import org.koin.core.module.Module
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


const val PRODUCTION_URL = "http://13.209.10.30:3000/"
const val TEST_URL = " http://3.34.242.198:8080/"
private val base_url: String = TEST_URL

fun getBaseUrl() = base_url

val networkModule: Module = module {
    fun provideRetrofit():Retrofit = Retrofit.Builder()
        .baseUrl(getBaseUrl())
        .addConverterFactory(GsonConverterFactory.create())
        .build()


    fun provideSignUp2Service(retrofit: Retrofit): SignUp2Service =
        retrofit.create(SignUp2Service::class.java)



    single { provideRetrofit() }
    single { provideSignUp2Service(get()) }

}

