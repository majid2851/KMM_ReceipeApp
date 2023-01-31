package com.codingwithmitch.kmm_learning_mitch.android.presentation.recipe_list

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.codingwithmitch.food2forkcompose.presentation.theme.AppTheme
import com.codingwithmitch.kmm_learning_mitch.android.presentation.components.GradientDemo
import com.codingwithmitch.kmm_learning_mitch.android.presentation.recipe_list.components.RecipeCard
import com.codingwithmitch.kmm_learning_mitch.android.presentation.recipe_list.components.RecipeList
import com.codingwithmitch.kmm_learning_mitch.presentation.recipe_list.RecipeStateList


@OptIn(ExperimentalComposeUiApi::class, ExperimentalMaterialApi::class)
@Composable
fun RecipeListScreen(
    state:RecipeStateList,
//    ,event:()->{}
    onSelectRecipe:(Int)->Unit)
{

    AppTheme(displayProgressBar = state.isLoading)
    {
        RecipeList(loading = state.isLoading, recipes =
        state.recipe, onClickRecipeListItem =onSelectRecipe )
    }



}

