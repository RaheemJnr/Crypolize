package com.raheemjnr.cryptolize.ui.components

import android.content.Context
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
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
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.raheemjnr.cryptolize.domain.models.detailModel.CoinDetail
import com.raheemjnr.cryptolize.utils.openUrl
import com.raheemjnr.cryptolize.utils.showShortToast

//
@ExperimentalAnimationApi
@Composable
fun ReferenceUI(
    coinDetail: CoinDetail,
    context: Context
) {
    //
    var arrowDirection by rememberSaveable { mutableStateOf(false) }
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
                color = MaterialTheme.colors.onPrimary.copy(alpha = 0.5f),
                modifier = Modifier,
                textAlign = TextAlign.Center,
                fontSize = 18.sp
            )
            //
            Icon(
                imageVector = if (arrowDirection) Icons.Filled.KeyboardArrowDown
                else Icons.Filled.KeyboardArrowUp,
                contentDescription = "",
                tint = MaterialTheme.colors.onPrimary.copy(alpha = 0.7f),
                modifier = Modifier
                    .clickable {
                        arrowDirection = !arrowDirection
                    }
                    .size(28.dp)
            )
        }
        // items
        Surface(
            color = MaterialTheme.colors.surface
        ) {
            AnimatedVisibility(
                visible = arrowDirection,
            ) {
                Column(
                    modifier = Modifier
                        .padding(12.dp)
                ) {
                    //homepage
                    Text(
                        text = "Homepage",
                        modifier = Modifier
                            .clickable {
                                coinDetail.links?.homepage.let {
                                    if (it != null && it.isNotEmpty()) {
                                        context.openUrl(it.first())
                                    } else {
                                        showShortToast(context, "cannot open link")
                                    }
                                }
                            }
                            .padding(4.dp),
                        textDecoration = TextDecoration.Underline,
                        fontWeight = FontWeight.Bold,
                        style = MaterialTheme.typography.body1,
                        color = MaterialTheme.colors.secondary
                    )
                    ReferenceDivider()
                    //twitter
                    Text(
                        text = "Twitter",
                        modifier = Modifier
                            .clickable {
                                coinDetail.links?.twitter_screen_name?.let { context.openUrl(it) }
                            }
                            .padding(4.dp),
                        textDecoration = TextDecoration.Underline,
                        fontWeight = FontWeight.Bold,
                        style = MaterialTheme.typography.body1,
                        color = MaterialTheme.colors.secondary
                    )
                    ReferenceDivider()
                    //github
                    Text(
                        text = "Github",
                        modifier = Modifier
                            .clickable {
                                coinDetail.links?.repos_url?.github.let {
                                    if (it != null && it.isNotEmpty()) {
                                        context.openUrl(it.first())
                                    } else {
                                        showShortToast(context, "cannot open link")
                                    }
                                }
                            }
                            .padding(4.dp),
                        textDecoration = TextDecoration.Underline,
                        fontWeight = FontWeight.Bold,
                        style = MaterialTheme.typography.body1,
                        color = MaterialTheme.colors.secondary
                    )
                    ReferenceDivider()
                    //bitbucket
                    Text(
                        text = "Bitbucket",
                        modifier = Modifier
                            .clickable {
                                coinDetail.links?.repos_url?.bitbucket.let {
                                    if (it != null && it.isNotEmpty()) {
                                        context.openUrl(it.first())
                                    } else {
                                        showShortToast(context, "cannot open link")
                                    }
                                }
                            }
                            .padding(4.dp),
                        textDecoration = TextDecoration.Underline,
                        fontWeight = FontWeight.Bold,
                        style = MaterialTheme.typography.body1,
                        color = MaterialTheme.colors.secondary
                    )
                }
            }
        }
    }
}

@Composable
fun ReferenceDivider() {
    //divider
    Divider(
        color = Color.Gray,
        modifier = Modifier
            .fillMaxWidth()
            .width(0.5.dp)
            .alpha(0.2f),
        startIndent = 40.dp
    )
}