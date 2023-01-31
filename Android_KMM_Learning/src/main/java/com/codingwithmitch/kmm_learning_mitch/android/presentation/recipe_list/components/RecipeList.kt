package com.codingwithmitch.kmm_learning_mitch.android.presentation.recipe_list.components

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import com.codingwithmitch.food2forkcompose.presentation.theme.AppTheme
import com.codingwithmitch.kmm_learning_mitch.domain.model.Recipe

@OptIn(ExperimentalComposeUiApi::class, ExperimentalMaterialApi::class)
@Composable
fun RecipeList(
    loading:Boolean,
    recipes:List<Recipe>,
    onClickRecipeListItem:(Int)->Unit,
)
{
    AppTheme(displayProgressBar = false)
    {
        LazyColumn()
        {
            itemsIndexed(items=recipes)
            {index,recipe->
                RecipeCard(recipe = recipe, onClick =
                {
                    onClickRecipeListItem(recipe.id)
                })
            }
        }

    }




}