package com.codingwithmitch.kmm_learning_mitch.android.presentation.recipe_list.components

import android.graphics.drawable.shapes.Shape
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Shapes
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.codingwithmitch.kmm_learning_mitch.android.presentation.components.RECIPE_IMAGE_HEIGHT
import com.codingwithmitch.kmm_learning_mitch.android.presentation.components.RecipeImgage
import com.codingwithmitch.kmm_learning_mitch.domain.model.Recipe

@Composable
fun RecipeCard(recipe:Recipe,onClick:()->Unit)
{
    Card(
        shape= MaterialTheme.shapes.small,
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 6.dp, top = 6.dp)
            .clickable(onClick = onClick)
            , elevation = 8.dp
    )
    {
        Column()
        {
            RecipeImgage(url = recipe.featuredImage, contentDescription =recipe.title)
            Row(modifier = Modifier.fillMaxWidth().padding(top = 8.dp, bottom = 8.dp,
                start = 8.dp, end = 8.dp))
            {
                Text(text = recipe.title, modifier =
                Modifier.fillMaxWidth(.85f).wrapContentWidth(align = Alignment.Start),
                style = MaterialTheme.typography.h3)

                Text(text = recipe.rating.toString(), modifier = Modifier
                    .wrapContentWidth(align = Alignment.End)
                    .align(Alignment.CenterVertically),
                style = MaterialTheme.typography.h5)
            }
        }

    }
}