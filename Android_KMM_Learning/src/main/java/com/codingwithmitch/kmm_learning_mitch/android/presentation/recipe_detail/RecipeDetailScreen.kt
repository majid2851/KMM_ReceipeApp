package com.codingwithmitch.kmm_learning_mitch.android.presentation.recipe_detail

import android.content.res.Resources
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import com.codingwithmitch.food2forkcompose.presentation.theme.AppTheme
import com.codingwithmitch.kmm_learning_mitch.domain.model.Recipe

@OptIn(ExperimentalComposeUiApi::class, ExperimentalMaterialApi::class)
@Composable
fun RecipeDetailScreen(receipe:Recipe?)
{
    AppTheme(displayProgressBar = false)
    {
        if (receipe==null)
        {
            Text("Receipe is Null,")
        }else
        {
            Text("${receipe.title}")

        }
    }



}