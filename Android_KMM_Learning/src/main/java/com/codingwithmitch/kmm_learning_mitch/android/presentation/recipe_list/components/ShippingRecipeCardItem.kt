package com.codingwithmitch.kmm_learning_mitch.android.presentation.recipe_list.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp

@Preview
@Composable
fun ShimmerRecipeCardItem(
    colors:List<Color>,
    xShimmer:Float,
    yShimmer:Float,
    cardHeight:Dp,
    gradientWidth:Float,
    padding:Dp,
){
    val brush=Brush.linearGradient(
        colors = colors,
        start = Offset(xShimmer-gradientWidth,yShimmer-gradientWidth),
        end = Offset(xShimmer,yShimmer)
    )
    Column(modifier = Modifier.padding(padding))
    {
        Surface(shape = MaterialTheme.shapes.small)
        {
            Spacer(modifier = Modifier.fillMaxWidth().
                height(cardHeight)
                .background(brush = brush))
        }

    }

}