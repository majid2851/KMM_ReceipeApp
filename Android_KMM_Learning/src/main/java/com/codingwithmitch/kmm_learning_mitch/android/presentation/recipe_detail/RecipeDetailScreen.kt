package com.codingwithmitch.kmm_learning_mitch.android.presentation.recipe_detail

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.unit.dp
import com.codingwithmitch.food2forkcompose.presentation.theme.AppTheme
import com.codingwithmitch.kmm_learning_mitch.android.presentation.components.RECIPE_IMAGE_HEIGHT
import com.codingwithmitch.kmm_learning_mitch.android.presentation.recipe_detail.component.LoadingRecipeShimmer
import com.codingwithmitch.kmm_learning_mitch.android.presentation.recipe_detail.component.RecipeView
import com.codingwithmitch.kmm_learning_mitch.presentation.recipe_detail.RecipeDetailEvents
import com.codingwithmitch.kmm_learning_mitch.presentation.recipe_detail.RecipeDetailState
import com.codingwithmitch.kmm_learning_mitch.presentation.recipe_list.RecipeListEvents
import kotlinx.coroutines.delay

@OptIn(ExperimentalComposeUiApi::class, ExperimentalMaterialApi::class)
@Composable
fun RecipeDetailScreen(
    state:RecipeDetailState,
    onTrigerEvent:(RecipeDetailEvents)->Unit
)
{
    AppTheme(displayProgressBar = state.isLoading , dialogQueue = state.queue,
        onRemoveHeadQueue =
        {
            onTrigerEvent(RecipeDetailEvents.OnRemoveHeadMessageFromQueue)
        })
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