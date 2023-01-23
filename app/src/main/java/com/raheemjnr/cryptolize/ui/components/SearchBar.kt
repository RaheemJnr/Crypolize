package com.raheemjnr.cryptolize.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CryptoListSearch(
    modifier: Modifier
) {
    val focusManager = LocalFocusManager.current
    var searchValue by remember { mutableStateOf("") }
    Row(
        modifier = modifier
    ) {
        OutlinedTextField(
            modifier = Modifier
                .wrapContentSize()
                .requiredHeight(60.dp)
                .requiredWidth(255.dp)
                .padding(4.dp),
            value = searchValue,
            onValueChange = {
                searchValue = it
            },
            label = {
                Text(text = "Search")
            },
            leadingIcon = {
                Icon(
                    Icons.Filled.Search, contentDescription = "search icon",
                    tint = MaterialTheme.colorScheme.secondary,
                    modifier = Modifier.size(16.dp)
                )
            },
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Done
            ),
            keyboardActions = KeyboardActions(
                onDone = {
                    //code to execute
                    focusManager.clearFocus()
                }
            ),
            textStyle = TextStyle(
                color = MaterialTheme.colorScheme.onSurface,
                background = MaterialTheme.colorScheme.surface
            ),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = MaterialTheme.colorScheme.primary,
                unfocusedBorderColor = MaterialTheme.colorScheme.secondary,
                unfocusedLabelColor = MaterialTheme.colorScheme.secondary,
                focusedLabelColor = MaterialTheme.colorScheme.primary

            )
        )
    }
}

@Preview
@Composable
fun SearchbarPrev() {

    CryptoListSearch(modifier = Modifier)
}