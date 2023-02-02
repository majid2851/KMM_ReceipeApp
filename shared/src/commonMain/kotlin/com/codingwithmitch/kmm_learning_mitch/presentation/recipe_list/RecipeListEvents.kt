package com.codingwithmitch.kmm_learning_mitch.presentation.recipe_list

sealed class RecipeListEvents
{
    object LoadRecipes:RecipeListEvents()

    object nextPage:RecipeListEvents()



}