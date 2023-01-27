package com.codingwithmitch.kmm_learning_mitch.android.presentation.recipe_detail

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import com.codingwithmitch.kmm_learning_mitch.domain.model.Recipe

@Composable
fun RecipeDetailScreen(receipe:Recipe?)
{
    if (receipe==null)
    {
        Text("ERROR")
    }else
    {
        Text("RecipeDetailId=${receipe.title}")

    }

}