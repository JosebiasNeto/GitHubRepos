package com.example.githubrepos.ui.github

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.githubrepos.R
import com.example.githubrepos.domain.model.GitHubRepository
import com.example.githubrepos.ui.components.GitHubRepositoryCard
import com.example.githubrepos.ui.components.ShowGetOwnerDialog
import com.example.githubrepos.ui.theme.defaultBackgroundWhite
import org.koin.androidx.viewmodel.ext.android.viewModel

class GitHubFragment : Fragment() {

    private val viewModel: GitHubViewModel by viewModel()
    private lateinit var repositoriesList: List<GitHubRepository>
    private var getOwnerDialogIsVisible = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = ComposeView(inflater.context).apply {
        setContent {
            repositoriesList = viewModel.gitHubRepositories
            getOwnerDialogIsVisible = viewModel.getOwnerDialogIsVisible.value

            Box{
                Column(
                    Modifier
                        .fillMaxSize()
                        .background(defaultBackgroundWhite)) {
                    Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween){
                        Text("WeFit", fontSize = 25.sp, modifier = Modifier.padding(all = 25.dp),
                        fontWeight = FontWeight.Bold)
                        IconButton(onClick = { viewModel.showGetOwnerDialog() },
                            modifier = Modifier.padding(all = 20.dp)) {
                            Icon(painter = painterResource(id = R.drawable.ic_baseline_settings_24),
                            contentDescription = null, modifier = Modifier.size(30.dp))
                        }
                    }
                    LazyColumn{
                        items(repositoriesList.size){ repo ->
                            GitHubRepositoryCard(repositoriesList[repo], false
                            ) {
                                viewModel.favoriteGitHubRepository(repositoriesList[repo])
                            }
                        }
                    }
                }
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