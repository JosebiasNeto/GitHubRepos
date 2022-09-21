package com.example.githubrepos.di

import android.app.Application
import com.example.githubrepos.di.Modules.data
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class GitHubReposApp : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@GitHubReposApp)
            modules(data)
        }
    }
}