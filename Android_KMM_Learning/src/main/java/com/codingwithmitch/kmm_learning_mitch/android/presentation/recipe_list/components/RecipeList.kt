package com.codingwithmitch.kmm_learning_mitch.android.presentation.recipe_list.components

import android.util.Log
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.unit.dp
import com.codingwithmitch.food2forkcompose.presentation.theme.AppTheme
import com.codingwithmitch.kmm_learning_mitch.android.presentation.components.RECIPE_IMAGE_HEIGHT
import com.codingwithmitch.kmm_learning_mitch.datasource.network.RecipeServiceImpl.Companion.RECIPE_PAGINATION_PAGE_SIZE
import com.codingwithmitch.kmm_learning_mitch.domain.model.Recipe

@OptIn(ExperimentalComposeUiApi::class, ExperimentalMaterialApi::class)
@Composable
fun RecipeList(
    loading:Boolean,
    recipes:List<Recipe>,
    page:Int,
    onTrigerNextPage:()->Unit,
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
                Log.i("testIndex","index=${index}"+"\t"+"size:"+page* RECIPE_PAGINATION_PAGE_SIZE)
                if ((index+1)>=(page*RECIPE_PAGINATION_PAGE_SIZE)&& !loading)
                {
                    onTrigerNextPage()
                }

                RecipeCard(recipe = recipe, onClick =
                {
                    onClickRecipeListItem(recipe.id)
                })
            }
        }


    }







}