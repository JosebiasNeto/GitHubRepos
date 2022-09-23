package com.example.githubrepos.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.githubrepos.domain.model.GitHubRepository
import com.example.githubrepos.ui.theme.grey
import com.example.githubrepos.ui.theme.yellowDark
import com.example.githubrepos.ui.theme.yellowLight
import com.example.githubrepos.R

@Composable
fun GitHubRepositoryCard(
    gitHubRepository: GitHubRepository,
    isFavorite: Boolean,
    onButtonPressed: () -> Unit
){
    if(gitHubRepository.description == null){
        gitHubRepository.description = ""
    }
    Card(modifier = Modifier.padding(all = 15.dp),
    elevation = 15.dp){
        Column(modifier = Modifier.padding(15.dp)) {
            Row(Modifier.fillMaxWidth()
                , horizontalArrangement = Arrangement.SpaceBetween){
                Text(gitHubRepository.name)
                Image(painter = rememberAsyncImagePainter(model = gitHubRepository.owner.avatar),
                contentDescription = null,
                modifier = Modifier.size(50.dp))
            }
            Divider(Modifier.height(1.dp))
            Text(gitHubRepository.description!!)
            Row(){
                GetCardButton(isFavorite, onButtonPressed)
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

@Composable
fun GetCardButton(isFavorite: Boolean, onButtonPressed: () -> Unit){
    if(isFavorite){

    } else {
        Card(modifier = Modifier
            .padding(top = 10.dp)
            .clickable { onButtonPressed() }
            .border(1.dp, grey, RoundedCornerShape(5.dp))
            .size(150.dp, 50.dp), backgroundColor = yellowLight
        ){
            Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Row{
                    Icon(painterResource(id = R.drawable.ic_baseline_star_24),
                    contentDescription = null,
                    tint = yellowDark)
                    Text(text = "Favoritar", color = yellowDark)
                }
            }
        }
    }
}