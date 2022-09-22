package com.example.githubrepos.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "githubrepositories")
class GitHubRepositoryEntity(
    @PrimaryKey
    var id: Int,
    var name: String,
    var description: String,
    var owner: String,
    var stargazers: Int,
    var language: String,
    var link: String,
)