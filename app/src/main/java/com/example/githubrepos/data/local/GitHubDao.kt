package com.example.githubrepos.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface GitHubDao {

    @Insert
    suspend fun insertGitHubRepository(gitHubRepositoryEntity: GitHubRepositoryEntity)

    @Query("SELECT * FROM githubrepositories")
    suspend fun getGitHubRepositories(): List<GitHubRepositoryEntity>

    @Query("DELETE FROM githubrepositories WHERE id = :gitHubRepositoryId")
    suspend fun deleteFavoriteGitHubRepository(gitHubRepositoryId: Int)

}