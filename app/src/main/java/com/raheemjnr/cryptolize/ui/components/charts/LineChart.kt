package com.raheemjnr.cryptolize.ui.components.charts

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.dp
import kotlin.math.min

@Composable
fun LineChart(
    modifier: Modifier = Modifier,
    lineColors: List<Color> = listOf(MaterialTheme.colors.primary, MaterialTheme.colors.primary),
    lineWidth: Float = 4f,
    yAxisValues: List<Float>,
    shouldAnimate: Boolean = true,
) {
    val yValues = remember { yAxisValues }
    val x = remember { androidx.compose.animation.core.Animatable(0f) }
    val xTarget = (yValues.size - 1).toFloat()

    LaunchedEffect(Unit) {
        x.animateTo(
            targetValue = xTarget,
            animationSpec = tween(
                durationMillis = if (shouldAnimate) 500 else 0,
                easing = LinearEasing
            ),
        )
    }

    Canvas(modifier = modifier.padding(8.dp)) {
        val path = Path()
        val xBounds = Pair(0f, xTarget)
        val yBounds = getBounds(yValues)
        val scaleX = size.width / (xBounds.second - xBounds.first)
        val scaleY = size.height / (yBounds.second - yBounds.first)
        val yMove = yBounds.first * scaleY

        (0..min(yValues.size - 1, x.value.toInt())).forEach { value ->
            val xPoint = value * scaleX
            val yPoint = size.height - (yValues[value] * scaleY) + yMove
            if (value == 0) {
                path.moveTo(0f, yPoint)
                return@forEach
            }
            path.lineTo(xPoint, yPoint)
        }

        drawPath(
            path = path,
            brush = Brush.linearGradient(lineColors),
            style = Stroke(width = lineWidth)
        )
    }
}

fun getBounds(list: List<Float>): Pair<Float, Float> {
    var min = Float.MAX_VALUE
    var max = -Float.MAX_VALUE
    list.forEach {
        min = min.coerceAtMost(it)
        max = max.coerceAtLeast(it)
    }
    return Pair(min, max)
}