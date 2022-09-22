package com.example.githubrepos.data.remote

import com.example.githubrepos.domain.model.GitHubRepository
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("{owner}/repos")
    suspend fun getAllGitHubRepositories(@Path("owner") owner: String): ArrayList<GitHubRepository>
}