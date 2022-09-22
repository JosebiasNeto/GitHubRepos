package com.example.githubrepos.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.compose.ui.window.SecureFlagPolicy

@Composable
fun ShowGetOwnerDialog(
    onSavePressed: (String) -> Unit,
    currentOwner: String,
    onCancelPressed: () -> Unit
){
    Dialog(onDismissRequest = onCancelPressed, properties = DialogProperties(
        dismissOnBackPress = true, dismissOnClickOutside = true, securePolicy = SecureFlagPolicy.SecureOn
    )){
        Card {
            Column {
                Row(Modifier.padding(all = 10.dp)) {
                    Text("Alterar usuario selecionado")
                    Card(Modifier.clickable { onCancelPressed }){

                    }
                }
                //TextField(value = , onValueChange = )
                Card(

                ){

                }
            }
        }
    }
}