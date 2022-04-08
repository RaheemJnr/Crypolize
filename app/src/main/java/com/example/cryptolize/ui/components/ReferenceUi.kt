package com.example.cryptolize.ui.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

//
@ExperimentalAnimationApi
@Composable
fun ReferenceUI() {
    //
    var arrowDirection by rememberSaveable { mutableStateOf(true) }
    //
    Column(
        modifier = Modifier
    ) {
        // Top row
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 8.dp, bottom = 6.dp, end = 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Reference Links",
                fontWeight = FontWeight.Bold,
                color = Color.Black.copy(alpha = 0.5f),
                modifier = Modifier,
                textAlign = TextAlign.Center,
                fontSize = 18.sp
            )
            //
            Icon(
                imageVector = if (arrowDirection) Icons.Filled.KeyboardArrowDown
                else Icons.Filled.KeyboardArrowUp,
                contentDescription = "",
                tint = Color.Black.copy(alpha = 0.7f),
                modifier = Modifier.clickable {
                    arrowDirection = !arrowDirection
                }
            )
        }
        // items
        Column {
            AnimatedVisibility(
                visible = arrowDirection,
            ) {
                Column(
                    modifier = Modifier
                        .background(Color.White)
                        .padding(8.dp)
                ) {
                    Text(text = "heree")
                    //divider
                    Divider(
                        color = Color.Gray,
                        modifier = Modifier
                            .fillMaxWidth()
                            .width(0.5.dp)
                            .alpha(0.2f),
                        startIndent = 65.dp
                    )
                    Text(text = "here twoo")

                }
            }

        }

    }

}