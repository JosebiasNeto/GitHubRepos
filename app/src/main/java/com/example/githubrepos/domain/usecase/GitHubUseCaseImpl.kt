package com.example.githubrepos.domain.usecase

import android.util.Log
import com.example.githubrepos.data.local.ConvertLocalDatabaseEntity
import com.example.githubrepos.data.local.GitHubDao
import com.example.githubrepos.data.remote.ApiService
import com.example.githubrepos.domain.model.GitHubOwner
import com.example.githubrepos.domain.model.GitHubRepository

class GitHubUseCaseImpl(
    private val gitHubApiService: ApiService,
    private val gitHubDatabase: GitHubDao
) : GitHubUseCase {

    override suspend fun getAllGitHubRepositories(owner: String): ArrayList<GitHubRepository> {
        try{
            return gitHubApiService.getAllGitHubRepositories(owner)
        } catch (e: Exception){
            Log.e(e.toString(), "Retrofit Error, API rate limit exceeded")
            return arrayListOf(
                GitHubRepository(
                    0,
                    "GitHubRepos",
                    "Repositorio mockado",
                    GitHubOwner("https://avatars.githubusercontent.com/u/79516718?s=400&u=2b62e5ed308f372b09c90670023dd098043fcee7&v=4"),
                    7,
                    "Kotlin",
                    "https://github.com/JosebiasNeto/GitHubRepos"
                )
            )
        }
    }

    override suspend fun getFavoritiesGitHubRepositories(): ArrayList<GitHubRepository> {
        val gitHubRepositories = arrayListOf<GitHubRepository>()
        gitHubDatabase.getGitHubRepositories().forEach {
            gitHubRepositories.add(
                ConvertLocalDatabaseEntity().fromDatabase(it)
            )
        }
        return gitHubRepositories
    }

    override suspend fun favoriteGitHubRepository(gitHubRepository: GitHubRepository) {
        gitHubDatabase.insertGitHubRepository(
            ConvertLocalDatabaseEntity().toDatabase(gitHubRepository))
    }

    override suspend fun deleteFavoriteGitHubRepository(gitHubRepositoryId: Int) {
        gitHubDatabase.deleteFavoriteGitHubRepository(gitHubRepositoryId)
    }
}