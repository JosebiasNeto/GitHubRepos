package com.example.githubrepos.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.githubrepos.domain.model.GitHubRepository

@Composable
fun GitHubRepositoryCard(
    gitHubRepository: GitHubRepository,
    isFavorite: Boolean
){
    Card(modifier = Modifier.padding(all = 15.dp)){
        Column {
            Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween){
                Text(gitHubRepository.name)
                Image(painter = rememberAsyncImagePainter(model = gitHubRepository.owner.avatar),
                contentDescription = null,
                modifier = Modifier.size(50.dp))
            }
            Divider()
            //Text()
            Row(){
                Card(){

                }
                //Spacer(modifier = )
                //Icon()
                //Text()
                //Spacer(modifier = )
                //Box()
                //Text()
            }
        }
    }
}