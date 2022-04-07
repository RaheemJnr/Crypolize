package com.example.cryptolize.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun InfoUI() {
    Column(
        modifier = Modifier.padding(8.dp)
    ) {
        //name and image
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            Text(
                text = "Image",
                style = MaterialTheme.typography.body2
            )
            Text(
                text = "Dot",
                style = MaterialTheme.typography.body1,
                textAlign = TextAlign.Center
            )
        }
        //rank and position
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            Text(
                text = "Rank",
                style = MaterialTheme.typography.body2
            )
            Text(
                text = "23",
                style = MaterialTheme.typography.body1,
                textAlign = TextAlign.Center
            )
        }
        //market cap
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            Text(
                text = "Market Cap",
                style = MaterialTheme.typography.body2
            )
            Text(
                text = "$23Billion",
                style = MaterialTheme.typography.body1,
                textAlign = TextAlign.Center
            )
        }
        //circulation supply
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            Text(
                text = "Circulation Supply",
                style = MaterialTheme.typography.body2
            )
            Text(
                text = "$23Billion",
                style = MaterialTheme.typography.body1,
                textAlign = TextAlign.Center
            )
        }
        //max supply
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            Text(
                text = "Max Supply",
                style = MaterialTheme.typography.body2
            )
            Text(
                text = "$23Billion",
                style = MaterialTheme.typography.body1,
                textAlign = TextAlign.Center
            )
        }
        //total supply
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            Text(
                text = "Total Supply",
                style = MaterialTheme.typography.body2
            )
            Text(
                text = "$23Billion",
                style = MaterialTheme.typography.body1,
                textAlign = TextAlign.Center
            )
        }
    }
}

@Preview
@Composable
fun InfoUIPrev() {
    InfoUI()
}