package com.codingwithmitch.kmm_learning_mitch.android.presentation.recipe_list

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.ExperimentalComposeUiApi
import com.codingwithmitch.food2forkcompose.presentation.theme.AppTheme
import com.codingwithmitch.kmm_learning_mitch.android.presentation.recipe_list.components.RecipeList
import com.codingwithmitch.kmm_learning_mitch.android.presentation.recipe_list.components.SearchAppBar
import com.codingwithmitch.kmm_learning_mitch.presentation.recipe_list.FoodCategoryUtil
import com.codingwithmitch.kmm_learning_mitch.presentation.recipe_list.RecipeListEvents
import com.codingwithmitch.kmm_learning_mitch.presentation.recipe_list.RecipeStateList


@OptIn(ExperimentalComposeUiApi::class, ExperimentalMaterialApi::class)
@Composable
fun RecipeListScreen(
    state:RecipeStateList,
    onTrigerEvent:(RecipeListEvents)->Unit,
    onSelectRecipe:(Int)->Unit)
{

    AppTheme(
        displayProgressBar = state.isLoading,
        dialogQueue = state.queue,
        onRemoveHeadQueue =
        {
            onTrigerEvent(RecipeListEvents.OnRemoveHeadMessageFromQueue)
        })
    {
        val foodCategory= remember {FoodCategoryUtil().getAllFoodCategories()}
        Scaffold(topBar = { SearchAppBar(query =state.query ,
            onQueryChange = {
                onTrigerEvent(RecipeListEvents.onUpdateQuery(it))
            },
            onExcuteSearch = {
               onTrigerEvent(RecipeListEvents.newSearch)
            },
            selectedCategory=state.selectedCategory,
            categories = foodCategory,
            onSelectCategory = {
                onTrigerEvent(RecipeListEvents.onSelectCategory(it))
            })
        })
        {

            RecipeList(loading = state.isLoading, recipes =
            state.recipe, onClickRecipeListItem =onSelectRecipe,
                page = state.page, onTrigerNextPage = {onTrigerEvent(RecipeListEvents.nextPage)})

        }

    }



}

