package com.example.githubrepos.ui.favorite

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.githubrepos.domain.model.GitHubRepository
import com.example.githubrepos.domain.usecase.GitHubUseCase
import kotlinx.coroutines.launch

class FavoriteViewModel(
    private val useCase: GitHubUseCase
): ViewModel() {

    private val _favoritesRepositories = mutableStateListOf<GitHubRepository>()
    val favoritesRepositories: List<GitHubRepository> = _favoritesRepositories

    fun getFavoritesGitHubRepositories(){
        viewModelScope.launch {
            _favoritesRepositories.clear()
            _favoritesRepositories.addAll(useCase.getFavoritiesGitHubRepositories())
        }
    }

    fun deleteFavoriteGitHubRepository(gitHubRepositoryId: Int){
        viewModelScope.launch {
            useCase.deleteFavoriteGitHubRepository(gitHubRepositoryId)
            getFavoritesGitHubRepositories()
        }
    }
}