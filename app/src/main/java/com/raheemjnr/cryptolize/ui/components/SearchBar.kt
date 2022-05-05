package com.raheemjnr.cryptolize.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun CryptoListSearch(
    modifier: androidx.compose.ui.Modifier
) {
    val focusManager = LocalFocusManager.current
    var searchValue by remember { mutableStateOf("") }
    Row(
        modifier = modifier
    ) {
        OutlinedTextField(
            modifier = androidx.compose.ui.Modifier
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
                    tint = MaterialTheme.colors.onSurface,
                    modifier = androidx.compose.ui.Modifier.size(16.dp)
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
//                color = MaterialTheme.colors.onSurface,
//               background = MaterialTheme.colors.surface
            )
        )
    }

}

@Preview
@Composable
fun SearchbarPrev() {

    CryptoListSearch(modifier = androidx.compose.ui.Modifier)
}