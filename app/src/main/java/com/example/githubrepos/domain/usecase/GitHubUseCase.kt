package com.example.githubrepos.domain.usecase

import com.example.githubrepos.domain.model.GitHubRepository

interface GitHubUseCase {

    suspend fun getAllGitHubRepositories(owner: String): List<GitHubRepository>
    suspend fun getFavoritiesGitHubRepositories(): List<GitHubRepository>
    suspend fun favoriteGitHubRepository(gitHubRepository: GitHubRepository)
    suspend fun deleteFavoriteGitHubRepository(gitHubRepositoryId: Int)

}