package com.example.githubrepos.ui.github

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.res.painterResource
import com.example.githubrepos.R
import com.example.githubrepos.domain.model.GitHubRepository
import com.example.githubrepos.ui.components.GitHubRepositoryCard
import com.example.githubrepos.ui.components.ShowGetOwnerDialog
import com.example.githubrepos.ui.theme.defaultBackgroundWhite
import org.koin.androidx.viewmodel.ext.android.viewModel

class GitHubFragment : Fragment() {

    private val viewModel: GitHubViewModel by viewModel()
    private lateinit var repositoriesList: ArrayList<GitHubRepository>
    private var getOwnerDialogIsVisible = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = ComposeView(inflater.context).apply {
        setContent {
            repositoriesList = viewModel.gitHubRepositories.value
            getOwnerDialogIsVisible = viewModel.getOwnerDialogIsVisible.value

            Box{
                Column(
                    Modifier
                        .fillMaxSize()
                        .background(defaultBackgroundWhite)) {
                    Row(){
                        Text("WeFit")
                        IconButton(onClick = { viewModel.showGetOwnerDialog() }) {
                            Icon(painter = painterResource(id = R.drawable.ic_baseline_settings_24),
                            contentDescription = null)
                        }
                    }
                    LazyColumn{
                        items(repositoriesList.size){ repo ->
                            GitHubRepositoryCard(repositoriesList[repo], false)
                        }
                    }
                }
            }
            if(viewModel.owner.value != ""){
                viewModel.getAllRepositories()
            }
            if(getOwnerDialogIsVisible){
                ShowGetOwnerDialog(
                    onSavePressed = {viewModel.setOwner(it)},
                    currentOwner = viewModel.owner.value,
                    onCancelPressed = {viewModel.dismissGetOwnerDialog()}
                )
            }
        }
    }
}