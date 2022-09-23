package com.example.githubrepos.ui.components

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.githubrepos.domain.model.GitHubRepository
import com.example.githubrepos.R
import com.example.githubrepos.domain.model.GitHubOwner
import com.example.githubrepos.ui.theme.*

@Composable
fun GitHubRepositoryCard(
    gitHubRepository: GitHubRepository,
    isFavorite: Boolean,
    onButtonPressed: (GitHubRepository) -> Unit
){
    if(gitHubRepository.description == null){
        gitHubRepository.description = ""
    }
    if(gitHubRepository.language == null){
        gitHubRepository.language = "Linguagem"
    }
    Card(modifier = Modifier.padding(all = 15.dp),
    elevation = 15.dp){
        Column(modifier = Modifier.padding(15.dp)) {
            Row(Modifier.fillMaxWidth()
                , horizontalArrangement = Arrangement.SpaceBetween){
                Text(gitHubRepository.name, modifier = Modifier.padding(top = 15.dp))
                Image(painter = rememberAsyncImagePainter(model = gitHubRepository.owner.avatar),
                contentDescription = null,
                modifier = Modifier
                    .size(50.dp)
                    .clip(CircleShape)
                    .padding(bottom = 10.dp))
            }
            Spacer(modifier = Modifier.height(10.dp))
            Divider(Modifier.height(1.dp))
            Spacer(modifier = Modifier.height(15.dp))
            Text(gitHubRepository.description!!, color = grey)
            Spacer(modifier = Modifier.height(15.dp))
            Row(verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()){
                GetCardButton(isFavorite, onButtonPressed, gitHubRepository)
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(painterResource(id = R.drawable.ic_baseline_star_24),
                    contentDescription = null, tint = yellowDark)
                    Spacer(modifier = Modifier.width(5.dp))
                    Text(gitHubRepository.stargazers.toString(),
                    color = grey)
                }
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Box(
                        Modifier
                            .background(redDark)
                            .clip(CircleShape)
                            .size(5.dp))
                    Spacer(modifier = Modifier.width(5.dp))
                    Text(gitHubRepository.language!!,
                        color = grey)
                }
            }
        }
    }
}
@Preview
@Composable
fun preview(){
    GitHubRepositoryCard(gitHubRepository = GitHubRepository(
        0,
        "GitHubRepos",
        "Repositorio mockado",
        GitHubOwner("https://avatars.githubusercontent.com/u/79516718?s=400&u=2b62e5ed308f372b09c90670023dd098043fcee7&v=4"),
        7,
        "Typescript",
        "https://github.com/JosebiasNeto/GitHubRepos"
    ), isFavorite = false) {

    }
}

@Composable
fun GetCardButton(isFavorite: Boolean, onButtonPressed: (GitHubRepository) -> Unit,
gitHubRepository: GitHubRepository){
    val backgroundCardColor: androidx.compose.ui.graphics.Color?
    val iconCardColor: androidx.compose.ui.graphics.Color?
    var textCard = ""
    val iconCard: Int?

    if(isFavorite) {
        backgroundCardColor = redLight
        iconCardColor = redDark
        textCard = "Remover"
        iconCard = R.drawable.ic_baseline_delete_24
    } else {
        backgroundCardColor = yellowLight
        iconCardColor = yellowDark
        textCard = "Favoritar"
        iconCard = R.drawable.ic_baseline_star_24
        }

        Card(modifier = Modifier
            .padding(top = 10.dp)
            .clickable { onButtonPressed(gitHubRepository) }
            .border(1.dp, grey, RoundedCornerShape(5.dp))
            .size(120.dp, 50.dp), backgroundColor = backgroundCardColor
        ){
            Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Row(verticalAlignment = Alignment.CenterVertically){
                    Icon(painterResource(id = iconCard),
                        contentDescription = null,
                        tint = iconCardColor)
                    Spacer(modifier = Modifier.width(10.dp))
                    Text(text = textCard, color = iconCardColor)
                }
            }
        }
}