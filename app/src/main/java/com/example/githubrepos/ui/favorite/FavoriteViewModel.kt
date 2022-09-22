package com.example.githubrepos.ui.favorite

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.githubrepos.domain.model.GitHubRepository
import com.example.githubrepos.domain.usecase.GitHubUseCase
import kotlinx.coroutines.launch

class FavoriteViewModel(
    private val useCase: GitHubUseCase
): ViewModel() {
    private val _favoritesRepositories = MutableLiveData<ArrayList<GitHubRepository>>()
    val favoritesRepositories: LiveData<ArrayList<GitHubRepository>> = _favoritesRepositories

    fun getFavoritesGitHubRepositories(){
        viewModelScope.launch {
            _favoritesRepositories.postValue(useCase.getFavoritiesGitHubRepositories())
        }
    }

    fun deleteFavoriteGitHubRepository(gitHubRepositoryId: Int){
        viewModelScope.launch {
            useCase.deleteFavoriteGitHubRepository(gitHubRepositoryId)
            _favoritesRepositories.value?.forEach {
                if(it.id == gitHubRepositoryId){
                    _favoritesRepositories.value!!.remove(it)
            }
            }
        }
    }
}