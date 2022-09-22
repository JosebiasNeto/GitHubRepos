package com.example.githubrepos.ui.components

import com.example.githubrepos.R

sealed class BottomNavItem(var icon:Int, var screen_route:String) {

    object GitHubBottomNav : BottomNavItem(R.drawable.iconmonstr_github_1, "github")
    object FavoriteBottomNav : BottomNavItem(R.drawable.ic_baseline_star_24, "favorite")
}