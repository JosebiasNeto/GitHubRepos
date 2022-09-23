package com.example.githubrepos.data.local

import com.example.githubrepos.domain.model.GitHubOwner
import com.example.githubrepos.domain.model.GitHubRepository

class ConvertLocalDatabaseEntity {
    fun toDatabase(gitHubRepository: GitHubRepository): GitHubRepositoryEntity{
        if(gitHubRepository.description == null){
            gitHubRepository.description = ""
        }
        if(gitHubRepository.language == null){
            gitHubRepository.language = "Linguagem"
        }
        return GitHubRepositoryEntity(
            gitHubRepository.id,
            gitHubRepository.name,
            gitHubRepository.description!!,
            gitHubRepository.owner.avatar,
            gitHubRepository.stargazers,
            gitHubRepository.language!!,
            gitHubRepository.link
        )
    }
    fun fromDatabase(gitHubRepositoryEntity: GitHubRepositoryEntity): GitHubRepository{
        return GitHubRepository(
            gitHubRepositoryEntity.id,
            gitHubRepositoryEntity.name,
            gitHubRepositoryEntity.description,
            GitHubOwner(gitHubRepositoryEntity.owner),
            gitHubRepositoryEntity.stargazers,
            gitHubRepositoryEntity.language,
            gitHubRepositoryEntity.link
        )
    }
}