package com.example.cryptolize.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ListHeader() {
    Surface() {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            Text(
                text = "Name/Pair",
                fontSize = 16.sp,
                fontWeight = FontWeight.Light,
                fontFamily = FontFamily.SansSerif
            )
            //
            Text(
                text = "Last Price",
                fontSize = 16.sp,
                fontWeight = FontWeight.Light,
                fontFamily = FontFamily.SansSerif
            )
            //
            Text(
                text = "24h Change",
                fontSize = 16.sp,
                fontWeight = FontWeight.Light,
                fontFamily = FontFamily.SansSerif
            )
        }
    }
}

@Preview
@Composable
fun ListHeaderPreview() {
    ListHeader()
}