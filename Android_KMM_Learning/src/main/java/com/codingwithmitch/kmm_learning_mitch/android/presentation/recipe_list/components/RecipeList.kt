package com.codingwithmitch.kmm_learning_mitch.android.presentation.recipe_list.components

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.unit.dp
import com.codingwithmitch.food2forkcompose.presentation.theme.AppTheme
import com.codingwithmitch.kmm_learning_mitch.android.presentation.components.RECIPE_IMAGE_HEIGHT
import com.codingwithmitch.kmm_learning_mitch.domain.model.Recipe

@OptIn(ExperimentalComposeUiApi::class, ExperimentalMaterialApi::class)
@Composable
fun RecipeList(
    loading:Boolean,
    recipes:List<Recipe>,
    onClickRecipeListItem:(Int)->Unit,
)
{
    if (loading==true && recipes.isEmpty())
    {
        /*Loading Condition*/
        LoadingRecipeListShimmer(RECIPE_IMAGE_HEIGHT.dp,)

    }
    else if (recipes.isEmpty())
    {
        /*Nothing to show ,empty list*/

    }else
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