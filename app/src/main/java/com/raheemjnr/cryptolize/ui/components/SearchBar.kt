package com.raheemjnr.cryptolize.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun CryptoListSearch(
    query: String,
    onTextChange: (String) -> Unit,
    onSearchClicked: (String) -> Unit,
    modifier: Modifier
) {
    val focusManager = LocalFocusManager.current
    Row(
        modifier = modifier
    ) {
        OutlinedTextField(
            modifier = Modifier
                .wrapContentSize()
                .requiredHeight(60.dp)
                .requiredWidth(255.dp)
                .padding(4.dp),
            value = query,
            onValueChange = {
                onTextChange(it)
            },
            label = {
                Text(text = "Search")
            },
            leadingIcon = {
                Icon(
                    Icons.Filled.Search, contentDescription = "search icon",
                    tint = MaterialTheme.colors.secondary,
                    modifier = Modifier.size(16.dp)
                )
            },
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Search
            ),
            keyboardActions = KeyboardActions(
                onSearch = {
                    //code to execute
                    onSearchClicked(query)
                    focusManager.clearFocus()
                }
            ),
            textStyle = TextStyle(
                color = MaterialTheme.colors.onSurface,
                background = MaterialTheme.colors.surface
            ),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = MaterialTheme.colors.primary,
                unfocusedBorderColor = MaterialTheme.colors.secondary,
                unfocusedLabelColor = MaterialTheme.colors.secondary,
                focusedLabelColor = MaterialTheme.colors.primary

            )
        )
    }
}

@Preview
@Composable
fun SearchbarPrev() {

    // CryptoListSearch(modifier = Modifier, query = "")
}