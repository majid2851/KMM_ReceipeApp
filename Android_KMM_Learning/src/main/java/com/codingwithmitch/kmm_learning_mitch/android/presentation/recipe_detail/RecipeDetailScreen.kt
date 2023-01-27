package com.codingwithmitch.kmm_learning_mitch.android.presentation.recipe_detail

import androidx.compose.material.Text
import androidx.compose.runtime.Composable

@Composable
fun RecipeDetailScreen(receipeId:Int?)
{
    if (receipeId==null)
    {
        Text("ERROR")
    }else
    {
        Text("RecipeDetailId=${receipeId}")

    }

}