package com.example.githubrepos.domain.usecase

import com.example.githubrepos.domain.model.GitHubRepository

interface GitHubUseCase {

    suspend fun getAllGitHubRepositories(owner: String): ArrayList<GitHubRepository>
    suspend fun getFavoritiesGitHubRepositories(): ArrayList<GitHubRepository>
    suspend fun favoriteGitHubRepository(gitHubRepository: GitHubRepository)
    suspend fun deleteFavoriteGitHubRepository(gitHubRepositoryId: Int)

}