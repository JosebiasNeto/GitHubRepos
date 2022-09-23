package com.example.githubrepos.ui.favorite

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.githubrepos.domain.model.GitHubRepository
import com.example.githubrepos.domain.usecase.GitHubUseCase
import kotlinx.coroutines.launch

class FavoriteViewModel(
    private val useCase: GitHubUseCase
): ViewModel() {

    val favoritesRepositories: MutableState<ArrayList<GitHubRepository>> = mutableStateOf(arrayListOf())

    fun getFavoritesGitHubRepositories(){
        viewModelScope.launch {
            favoritesRepositories.value = useCase.getFavoritiesGitHubRepositories()
        }
    }

    fun deleteFavoriteGitHubRepository(gitHubRepositoryId: Int){
        viewModelScope.launch {
            useCase.deleteFavoriteGitHubRepository(gitHubRepositoryId)
            var newList = arrayListOf<GitHubRepository>()
            newList = favoritesRepositories.value
            favoritesRepositories.value.forEach {
                if(it.id == gitHubRepositoryId){
                    newList.remove(it)
            }
            }
            favoritesRepositories.value = newList
        }
    }
}