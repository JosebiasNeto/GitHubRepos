package com.example.githubrepos.ui.components

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.compose.ui.window.SecureFlagPolicy
import com.example.githubrepos.ui.theme.grey
import com.example.githubrepos.R

@Composable
fun ShowGetOwnerDialog(
    onSavePressed: (String) -> Unit,
    currentOwner: String,
    onCancelPressed: () -> Unit
){
    var newOwner by remember { mutableStateOf(currentOwner)}
    Dialog(onDismissRequest = onCancelPressed, properties = DialogProperties(
        dismissOnBackPress = true, dismissOnClickOutside = true, securePolicy = SecureFlagPolicy.SecureOn
    )){
        Card(Modifier.fillMaxWidth()) {
            Column() {
                Row(Modifier.padding(all = 10.dp).fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                    Text("Alterar usuario selecionado")
                    Card(
                        Modifier
                            .clickable { onCancelPressed() }
                            .size(30.dp),
                    backgroundColor = grey){
                    Icon(painter = painterResource(id = R.drawable.ic_baseline_close_24),
                    contentDescription = null)
                    }
                }
                TextField(
                    value = newOwner, onValueChange = {
                    newOwner = it
                }, modifier = Modifier.align(Alignment.CenterHorizontally),
                    singleLine = true, )
                Card(modifier = Modifier
                    .padding(top = 10.dp)
                    .clickable { onSavePressed(newOwner) }
                    .border(1.dp, grey, RoundedCornerShape(30.dp))
                    .size(120.dp, 35.dp)
                    .align(Alignment.CenterHorizontally)
                ){
                    Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                        Text(
                            text = "Salvar",
                        )
                    }
                }
            }
        }
    }
}