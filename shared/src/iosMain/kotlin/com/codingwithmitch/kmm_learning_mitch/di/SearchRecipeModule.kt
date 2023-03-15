package com.codingwithmitch.kmm_learning_mitch.di

import com.codingwithmitch.kmm_learning_mitch.interactors.recipe_list.SearchRecipes

class SearchRecipeModule(val networkModule: NetworkModule)
{
    val searchRecipes:SearchRecipes by lazy()
    {
        SearchRecipes(
            recipeService = networkModule.recipeService
        )

    }









}