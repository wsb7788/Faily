package com.project.faily

import android.app.Application
import com.project.faily.di.networkModule
import com.project.faily.di.repositoryModule
import com.project.faily.di.utilityModule
import com.project.faily.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger

import org.koin.core.context.startKoin

class ApplicationClass : Application() {
    companion object {
        lateinit var instance: ApplicationClass
            private set
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        startKoin {
            /*if (DEBUG) {
                androidLogger()
            } else {*/
            androidLogger()
//        }
            androidContext(this@ApplicationClass)
            modules(
                utilityModule,
                viewModelModule,
                networkModule,
                repositoryModule
            )
        }
    }
}