package com.example.githubrepos.ui.favorite

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.githubrepos.domain.model.GitHubRepository
import com.example.githubrepos.ui.components.GitHubRepositoryCard
import com.example.githubrepos.ui.theme.defaultBackgroundWhite
import org.koin.androidx.viewmodel.ext.android.viewModel

class FavoriteFragment : Fragment() {

    private val viewModel: FavoriteViewModel by viewModel()
    private lateinit var repositoriesList: List<GitHubRepository>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = ComposeView(inflater.context).apply {
        setContent {
            viewModel.getFavoritesGitHubRepositories()
            repositoriesList = viewModel.favoritesRepositories
            Box {
                Column(
                    Modifier
                        .fillMaxSize()
                        .background(defaultBackgroundWhite)
                ) {
                    Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                        Text(
                            "Favorites", fontSize = 25.sp, modifier = Modifier.padding(all = 25.dp),
                            fontWeight = FontWeight.Bold
                        )
                    }
                    LazyColumn {
                        items(repositoriesList.size) { repo ->
                            GitHubRepositoryCard(
                                repositoriesList[repo], true
                            ) {
                                viewModel.deleteFavoriteGitHubRepository(repositoriesList[repo].id)
                            }
                        }
                    }
                }
            }
        }
    }
}