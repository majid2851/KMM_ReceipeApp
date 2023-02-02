package com.codingwithmitch.kmm_learning_mitch.android.presentation.recipe_detail

import android.content.res.Resources
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.codingwithmitch.food2forkcompose.presentation.theme.AppTheme
import com.codingwithmitch.kmm_learning_mitch.android.presentation.components.RECIPE_IMAGE_HEIGHT
import com.codingwithmitch.kmm_learning_mitch.android.presentation.components.RecipeImgage
import com.codingwithmitch.kmm_learning_mitch.android.presentation.recipe_detail.component.LoadingRecipeShimmer
import com.codingwithmitch.kmm_learning_mitch.android.presentation.recipe_detail.component.RecipeView
import com.codingwithmitch.kmm_learning_mitch.android.presentation.recipe_list.components.RecipeCard
import com.codingwithmitch.kmm_learning_mitch.domain.model.Recipe
import com.codingwithmitch.kmm_learning_mitch.presentation.recipe_detail.RecipeDetailEvents
import com.codingwithmitch.kmm_learning_mitch.presentation.recipe_detail.RecipeDetailState
import kotlinx.coroutines.delay

@OptIn(ExperimentalComposeUiApi::class, ExperimentalMaterialApi::class)
@Composable
fun RecipeDetailScreen(
    state:RecipeDetailState,
    onTrigerEvent:(RecipeDetailEvents)->Unit
)
{
    AppTheme(displayProgressBar = state.isLoading)
    {
        if (state.recipe==null && state.isLoading==true)
        {
            LoadingRecipeShimmer(imageHeight = RECIPE_IMAGE_HEIGHT.dp)
        }
        else if (state.recipe==null && state.isLoading==false)
        {
            LoadingRecipeShimmer(imageHeight = RECIPE_IMAGE_HEIGHT.dp)
        }
        else
        {
            RecipeView(recipe = state.recipe!!)
        }


    }



}