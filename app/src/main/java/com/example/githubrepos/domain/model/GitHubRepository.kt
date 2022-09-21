package com.example.githubrepos.domain.model

import androidx.room.Entity
import com.google.gson.annotations.SerializedName

@Entity(tableName = "githubrepositories")
data class GitHubRepository (

    @SerializedName("id")
    var id: Int,
    @SerializedName("full_name")
    var name: String,
    @SerializedName("description")
    var description: String?,
    @SerializedName("owner")
    var owner: GitHubOwner,
    @SerializedName("stargazers_count")
    var stargazers: Int,
    @SerializedName("language")
    var language: String,
    @SerializedName("html_url")
    var link: String,

)