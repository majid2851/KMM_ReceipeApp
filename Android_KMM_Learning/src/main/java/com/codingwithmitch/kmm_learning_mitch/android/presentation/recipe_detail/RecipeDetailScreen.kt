package com.codingwithmitch.kmm_learning_mitch.android.presentation.recipe_detail

import android.content.res.Resources
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.tooling.preview.Preview
import com.codingwithmitch.food2forkcompose.presentation.theme.AppTheme
import com.codingwithmitch.kmm_learning_mitch.android.presentation.components.RecipeImgage
import com.codingwithmitch.kmm_learning_mitch.android.presentation.recipe_detail.component.RecipeView
import com.codingwithmitch.kmm_learning_mitch.android.presentation.recipe_list.components.RecipeCard
import com.codingwithmitch.kmm_learning_mitch.domain.model.Recipe
import com.codingwithmitch.kmm_learning_mitch.presentation.recipe_detail.RecipeDetailEvents
import com.codingwithmitch.kmm_learning_mitch.presentation.recipe_detail.RecipeDetailState

@OptIn(ExperimentalComposeUiApi::class, ExperimentalMaterialApi::class)
@Composable
fun RecipeDetailScreen(
    state:RecipeDetailState,
    onTrigerEvent:(RecipeDetailEvents)->Unit
)
{
    AppTheme(displayProgressBar = state.isLoading)
    {
        if (state.recipe==null && state.isLoading)
        {
            //loading
        }else if (state.recipe==null && state.isLoading==false)
        {
            //nothing to show
        }else
        {
            RecipeView(recipe = state.recipe!!)
        }


    }



}