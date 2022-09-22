package com.example.githubrepos.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.githubrepos.domain.model.GitHubRepository

@Dao
interface GitHubDao {

    @Insert
    suspend fun insertGitHubRepository(gitHubRepository: GitHubRepository)

    @Query("SELECT * FROM githubrepositories")
    suspend fun getGitHubRepositories(): ArrayList<GitHubRepository>

    @Query("DELETE FROM githubrepositories WHERE id = :gitHubRepositoryId")
    suspend fun deleteFavoriteGitHubRepository(gitHubRepositoryId: Int)

}