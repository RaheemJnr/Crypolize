package com.raheemjnr.cryptolize.utils

import androidx.compose.animation.Animatable
import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.IntSize

@Composable
fun SkeletonShimmerAnimation(
    modifier: Modifier = Modifier,
    isLoading: Boolean = false,
    shape: Shape,
    contentAlignment: Alignment = Alignment.Center,
    contentView: @Composable () -> Unit = {},
    defaultView: (@Composable () -> Unit)? = null,
) {
    //default size for Ui component
    val defaultSize = remember { mutableStateOf(IntSize.Zero) }

    Box(
        modifier = modifier
            .wrapContentSize()
            .clip(shape = shape)
            .onSizeChanged {
                /**
                by default the size of the size of the skeleton box is zero
                but when recomposition happen and size change apply the change here
                 */
                defaultSize.value = it
            },
        contentAlignment = contentAlignment
    ) {
        //the main view we want to display after animation or expected response from server
        contentView()


        if (isLoading) {
            //if the UI state is still loading; we will display our loading skeleton animation
            defaultView?.let { view ->
                view()
            }
            //animated color for the UI skeleton
            val animatedColor = remember { Animatable(Color.White) }

            //holds value for when to animating the color of the Skeleton box
            val animationToggle = remember { mutableStateOf(false) }

            //if the value is true animate the color to light gray else back to white
            if (animationToggle.value) {
                LaunchedEffect(key1 = null) {
                    animatedColor.animateTo(
                        targetValue = Color.White,
                        animationSpec = tween(800, delayMillis = 50, easing = FastOutLinearInEasing)
                    )
                    animationToggle.value = false
                }
            } else {
                LaunchedEffect(key1 = null) {
                    animatedColor.animateTo(
                        targetValue = Color.LightGray,
                        animationSpec = tween(800, delayMillis = 50, easing = LinearOutSlowInEasing)
                    )
                    animationToggle.value = true
                }
            }
            /**
             *  default Skeleton Box for each UI item that will be animated and we applied
             *  the size changes from [defaultSize] value
             *  calculated in the [onSizeChanged] modifier above
             *  */
            Box(
                modifier = modifier
                    .background(animatedColor.value)
                    .then(
                        with(LocalDensity.current) {
                            Modifier.size(
                                width = defaultSize.value.width.toDp(),
                                height = defaultSize.value.height.toDp()
                            )
                        }
                    )
            )
        }
    }

}