package com.example.githubrepos.ui.components

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.compose.ui.window.SecureFlagPolicy
import com.example.githubrepos.ui.theme.grey
import com.example.githubrepos.R
import com.example.githubrepos.ui.theme.fullWhite

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
                Row(
                    Modifier
                        .padding(all = 10.dp)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                    ) {
                    Text("Alterar usuario selecionado",
                    modifier = Modifier.padding(top = 7.dp, start = 5.dp))
                    Card(
                        Modifier
                            .clip(CircleShape)
                            .clickable { onCancelPressed() }
                            .size(20.dp),
                    backgroundColor = grey){
                    Icon(painter = painterResource(id = R.drawable.ic_baseline_close_24),
                    contentDescription = null)
                    }
                }
                Spacer(modifier = Modifier.height(5.dp))
                OutlinedTextField(
                    value = newOwner, onValueChange = {
                    newOwner = it
                }, modifier = Modifier.align(Alignment.CenterHorizontally)
                        .size(250.dp, 50.dp),
                    singleLine = true, colors = TextFieldDefaults.textFieldColors(
                        backgroundColor = fullWhite,

                    ))
                Card(modifier = Modifier
                    .padding(top = 10.dp, bottom = 15.dp)
                    .clickable {
                        onSavePressed(newOwner)
                    }
                    .border(1.dp, grey, RoundedCornerShape(30.dp))
                    .size(180.dp, 35.dp)
                    .align(Alignment.CenterHorizontally),
                    backgroundColor = grey, shape = RoundedCornerShape(30.dp)
                ){
                    Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                        Text(text = "Salvar", fontWeight = FontWeight.Bold)
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun previewDialog(){
    ShowGetOwnerDialog(onSavePressed = {}, currentOwner = "") {

    }
}