package com.codingwithmitch.kmm_learning_mitch.android.presentation.components

import android.graphics.Color
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.google.accompanist.coil.rememberCoilPainter
import com.google.accompanist.imageloading.ImageLoadState

const val RECIPE_IMAGE_HEIGHT=260
@Composable
fun RecipeImgage(
    url:String,
    contentDescription:String
)
{
    val painter= rememberCoilPainter(request = url)
    Box()
    {
        Image(modifier = Modifier
            .fillMaxWidth()
            .height(RECIPE_IMAGE_HEIGHT.dp),
            painter = painter, contentDescription = contentDescription,
            contentScale = ContentScale.Crop)
    }
    when(painter.loadState)
    {
        is ImageLoadState.Error ->{}

        is ImageLoadState.Success ->{}

        is ImageLoadState.Loading ->
        {
            Box(modifier = Modifier.fillMaxWidth().height(RECIPE_IMAGE_HEIGHT.dp))
            {

            }
        }
    }



}