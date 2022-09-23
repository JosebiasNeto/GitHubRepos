package com.example.githubrepos.ui.github

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.githubrepos.domain.model.GitHubRepository
import com.example.githubrepos.domain.usecase.GitHubUseCase
import kotlinx.coroutines.launch

class GitHubViewModel(
    private val useCase: GitHubUseCase
): ViewModel() {

    val gitHubRepositories: MutableState<ArrayList<GitHubRepository>> = mutableStateOf(arrayListOf())
    val owner: MutableState<String> = mutableStateOf("")
    val getOwnerDialogIsVisible: MutableState<Boolean> = mutableStateOf(false)

    fun getAllRepositories(){
        viewModelScope.launch {
            gitHubRepositories.value = useCase.getAllGitHubRepositories(owner.value)
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
            gitHubRepositories.value.forEach {
                if(it.id == gitHubRepository.id){
                    gitHubRepositories.value.remove(it)
                }
            }
        }
    }
}