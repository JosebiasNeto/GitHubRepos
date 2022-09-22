package com.example.githubrepos.domain.usecase

import com.example.githubrepos.data.local.GitHubDao
import com.example.githubrepos.data.remote.ApiService
import com.example.githubrepos.domain.model.GitHubRepository

class GitHubUseCaseImpl(
    private val gitHubApiService: ApiService,
    private val gitHubDatabase: GitHubDao
) : GitHubUseCase {

    override suspend fun getAllGitHubRepositories(owner: String): ArrayList<GitHubRepository> {
        return gitHubApiService.getAllGitHubRepositories(owner)
    }

    override suspend fun getFavoritiesGitHubRepositories(): ArrayList<GitHubRepository> {
        return gitHubDatabase.getGitHubRepositories()
    }

    override suspend fun favoriteGitHubRepository(gitHubRepository: GitHubRepository) {
        gitHubDatabase.insertGitHubRepository(gitHubRepository)
    }

    override suspend fun deleteFavoriteGitHubRepository(gitHubRepositoryId: Int) {
        gitHubDatabase.deleteFavoriteGitHubRepository(gitHubRepositoryId)
    }
}