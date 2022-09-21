package com.example.githubrepos.di

import com.example.githubrepos.data.local.GitHubRoomDatabase
import com.example.githubrepos.data.remote.RetrofitBuilder
import com.example.githubrepos.domain.usecase.GitHubUseCase
import com.example.githubrepos.domain.usecase.GitHubUseCaseImpl
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

object Modules {
    val data = module {

        factory<GitHubUseCase> {
            GitHubUseCaseImpl(get(), get())
        }
        factory { RetrofitBuilder.gitHubRepositoriesApi }
        factory { GitHubRoomDatabase.getGitHubRoomDatabase(androidContext()).gitHubDao() }

    }
}