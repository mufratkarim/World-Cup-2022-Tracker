package com.mka.fifa.world.cup2022.encyclopedia.presentation.players.components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp

@Composable
fun FloatingSearchButton(onClick: (String) -> Unit) {
    val dialogState = remember { mutableStateOf(false) }
    val textState = remember { mutableStateOf(TextFieldValue()) }

    if (dialogState.value) {
        AlertDialog(
            onDismissRequest = {
                dialogState.value = false
                textState.value = TextFieldValue()
            },
            title = { Text("Search Player: ") },
            text = {
                TextField(
                    value = textState.value,
                    onValueChange = { textState.value = it },
                    label = { Text("Name") }
                )
            },
            confirmButton = {
                Button(
                    onClick = {
                        onClick(textState.value.text)
                        dialogState.value = false
                        textState.value = TextFieldValue()
                    }
                ) {
                    Text("OK")
                }
            },
            dismissButton = {
                Button(
                    onClick = {
                        dialogState.value = false
                        textState.value = TextFieldValue()
                    }
                ) {
                    Text("Cancel")
                }
            }
        )
    }

    FloatingActionButton(
        onClick = { dialogState.value = true },
        backgroundColor = MaterialTheme.colors.primary,
        contentColor = Color.White,
        shape = CircleShape,
        modifier = Modifier
            .padding(16.dp)
            .wrapContentSize(Alignment.BottomEnd)
    ) {
        Icon(Icons.Default.Search, contentDescription = "Add")
    }
}