package com.example.githubrepos.di

import com.example.githubrepos.data.local.GitHubRoomDatabase
import com.example.githubrepos.data.remote.RetrofitBuilder
import com.example.githubrepos.domain.usecase.GitHubUseCase
import com.example.githubrepos.domain.usecase.GitHubUseCaseImpl
import com.example.githubrepos.ui.favorite.FavoriteViewModel
import com.example.githubrepos.ui.github.GitHubViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

object Modules {
    val data = module {

        factory<GitHubUseCase> {
            GitHubUseCaseImpl(
                RetrofitBuilder.gitHubRepositoriesApi,
                GitHubRoomDatabase.getGitHubRoomDatabase(androidApplication()).gitHubDao())
        }

        viewModel {
            GitHubViewModel(get())
        }
        viewModel {
            FavoriteViewModel(get())
        }
    }
}