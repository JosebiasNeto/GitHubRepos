package com.example.githubrepos.domain.model

import com.google.gson.annotations.SerializedName

data class GitHubOwner(

    @SerializedName("avatar_url")
    var avatar: String

)