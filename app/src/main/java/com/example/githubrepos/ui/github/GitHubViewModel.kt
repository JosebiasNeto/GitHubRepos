package com.example.githubrepos.ui.github

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.githubrepos.domain.model.GitHubRepository
import com.example.githubrepos.domain.usecase.GitHubUseCase
import kotlinx.coroutines.launch

class GitHubViewModel(
    private val useCase: GitHubUseCase
): ViewModel() {

    private val _gitHubRepositories = MutableLiveData<ArrayList<GitHubRepository>>()
    val gitHubRepositories: LiveData<ArrayList<GitHubRepository>> = _gitHubRepositories

    private val _owner = MutableLiveData<String>()
    val owner: LiveData<String> = _owner

    fun getAllRepositories(){
        viewModelScope.launch {
            _owner.value?.let {
                _gitHubRepositories.postValue(useCase.getAllGitHubRepositories(it))
            }
        }
    }

    fun setOwner(setOwner: String){
        _owner.postValue(setOwner)
    }
}