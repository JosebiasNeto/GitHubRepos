package com.example.githubrepos.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import com.example.githubrepos.domain.model.GitHubRepository

@Composable
fun GitHubRepositoryCard(
    gitHubRepository: GitHubRepository,
    isFavorite: Boolean
){
    Card(){
        Column {
            Row(){

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