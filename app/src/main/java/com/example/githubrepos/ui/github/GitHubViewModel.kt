package com.example.githubrepos.ui.github

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.githubrepos.domain.model.GitHubRepository
import com.example.githubrepos.domain.usecase.GitHubUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class GitHubViewModel(
    private val useCase: GitHubUseCase
): ViewModel() {

    private val _gitHubRepositories = mutableStateListOf<GitHubRepository>()
    val gitHubRepositories: List<GitHubRepository> = _gitHubRepositories
    val owner: MutableState<String> = mutableStateOf("")
    val getOwnerDialogIsVisible: MutableState<Boolean> = mutableStateOf(false)

    fun getAllRepositories(){
        viewModelScope.launch(Dispatchers.IO) {
            _gitHubRepositories.clear()
            _gitHubRepositories.addAll(useCase.getAllGitHubRepositories(owner.value))
        }
    }

    fun setOwner(setOwner: String){
        owner.value = setOwner
        dismissGetOwnerDialog()
    }

    fun showGetOwnerDialog(){
        getOwnerDialogIsVisible.value = true
    }

    fun dismissGetOwnerDialog(){
        getOwnerDialogIsVisible.value = false
    }

    fun favoriteGitHubRepository(gitHubRepository: GitHubRepository){
        viewModelScope.launch {
            useCase.favoriteGitHubRepository(gitHubRepository)
            _gitHubRepositories.remove(gitHubRepository)
        }
    }
}